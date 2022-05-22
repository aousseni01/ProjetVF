/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

import Jama.Matrix;
import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javafx.scene.Group;

/**
 *
 * @author GWENDOLINE
 */
public class Treillis {

    //Attributs   
    private ArrayList<Barre> barres = new ArrayList();
    private ArrayList<Noeud> noeuds = new ArrayList();

    // Encapsulation 
    public ArrayList<Barre> getBarres() {
        return barres;
    }

    public ArrayList<Noeud> getNoeuds() {
        return noeuds;
    }

    //Constructeur
    public Treillis() {
        this.barres = new ArrayList<>();
        this.noeuds = new ArrayList<>();
    }

    //Methodes    
    public static Treillis treilliTest() {
        Treillis res;
        res = new Treillis();
        NoeudAppuiDouble n0 = new NoeudAppuiDouble(100, 300, new Vecteur2D(0, 0), 0);
        NoeudSimple n2 = new NoeudSimple(200, 200, new Vecteur2D(0, -1000), 2);
        NoeudAppuiSimple n1 = new NoeudAppuiSimple(100, 100, new Vecteur2D(0, 0), 1, 0);
        Barre b0 = new Barre(0, n0, n2, 0, 0, 20);
        Barre b1 = new Barre(1, n2, n1, 0, 0, 20);
        Barre b2 = new Barre(2, n0, n1, 0, 0, 20);
        res.ajouteBarre(b0);
        res.ajouteBarre(b1);
        res.ajouteBarre(b2);
        res.ajouteNoeud(n0);
        res.ajouteNoeud(n1);
        res.ajouteNoeud(n2);
        return res;
    }

    public int maxIdNoeud() {
        int max = 0;
        if (this.noeuds.size() != 0) {
            for (int i = 0; i < this.noeuds.size(); i++) {
                if (this.noeuds.get(i).getId() >= max) {
                    max = this.noeuds.get(i).getId();
                }
            }
        }
        return max;
    }

    public int maxIdBarre() {
        int max = 0;
        if (this.barres.size() != 0) {
            for (int i = 0; i < this.barres.size(); i++) {
                if (this.barres.get(i).getId() >= max) {
                    max = this.barres.get(i).getId();
                }
            }
        }
        return max;
    }

    public void ajouteNoeud(Noeud n) {
        if (this.noeuds.size() == 0) {
            n.setId(1);
            this.noeuds.add(n);
        } else {
            int i = 0;
            while (i < this.noeuds.size() && this.noeuds.get(i) != n) {
                i++;
            }
            if (i != this.noeuds.size()) {
                throw new Error("Ce noeud est deja dans le treillis");
            } else {
                n.setId(this.maxIdNoeud() + 1);
                this.noeuds.add(n);
            }
        }
    }

    public void ajouteBarre(Barre b) {
        int i = 0;
        if (this.barres.size() == 0) {
            b.setId(0);
            this.barres.add(b);
        } else {
            while ((this.barres.get(i) != b) && (i < this.barres.size() - 1)) {
                i++;
            }
            if (i != this.barres.size() - 1) {
                throw new Error("Cette barre est deja dans le treillis");
            } else {
                b.setId(this.maxIdBarre() + 1);
                this.barres.add(b);
            }
        }
    }

//Methode qui renvoie la liste des Inconnues
    public ArrayList<String> Inconnues() {
        int nombreInconnues;
        nombreInconnues = this.barres.size();
        for (int i = 0; i < this.noeuds.size(); i++) {
            nombreInconnues = nombreInconnues + this.noeuds.get(i).nbrInconnues();
        }
        ArrayList<String> Inconnues = new ArrayList();
        for (int j = 0; j < this.barres.size(); j++) {
            Inconnues.add("T" + j);
        }
        for (int y = 0; y < this.noeuds.size(); y++) {
            if (this.noeuds.get(y) instanceof NoeudSimple == false) {
                if (this.noeuds.get(y) instanceof NoeudAppuiSimple == true) {
                    Inconnues.add("R" + y);

                } else {
                    Inconnues.add("R" + y + "x");
                    Inconnues.add("R" + y + "y");
                }
            }
        }
        return Inconnues;
    }

    public double[][] miseEnEquationMatrice() {
        ArrayList<String> Inconnues = this.Inconnues();
        //Création de la matrice des equations
        double[][] Equation;
        Equation = new double[this.noeuds.size() * 2][Inconnues.size()];
        for (int i = 0; i < this.noeuds.size() * 2; i++) {
            for (int j = 0; j < Inconnues.size(); j++) {
                Equation[i][j] = 0;
            }
        }

        //Remplissage Réactions
        int lig = 0;
        for (int i = 0; i < this.noeuds.size(); i++) {
            Noeud n = this.noeuds.get(i);
            if (n instanceof NoeudSimple) {
            } else {
                if (n instanceof NoeudAppuiDouble) {
                    int num = this.numVar(Inconnues, n);
                    Equation[lig][num] = 1;
                    Equation[lig + 1][num + 1] = 1;
                } else {
                    int num = this.numVar(Inconnues, n);
                    NoeudAppuiSimple ns = (NoeudAppuiSimple) n;
                    double angle = ns.getNormale();
                    Equation[lig][num] = cos(angle);
                    Equation[lig + 1][num] = sin(angle);
                }
            }
            //Equation selon x pour les tensions dans les barres
            for (int j = 0; j < n.barresIncidentes().size(); j++) {
                Barre b = n.barresIncidentes().get(j);
                double angle = b.Angle(n);
                int col = this.numVar(Inconnues, b);
                Equation[lig][col] = cos(angle);
            }
            lig++;
            //Equation selon y pour les tensions dans les barres
            for (int j = 0; j < n.barresIncidentes().size(); j++) {
                Barre b = n.barresIncidentes().get(j);
                double angle = b.Angle(n);
                int col = this.numVar(Inconnues, b);
                Equation[lig][col] = sin(angle);

            }
            lig++;
        }
        return Equation;
    }

//Equivalent qu vecteur B dans AX=B
    public double[] miseEnEquationForces() {
        double[] B = new double[this.noeuds.size() * 2];
        int lig = 0;
        for (int i = 0; i < this.noeuds.size(); i++) {
            B[lig] = this.noeuds.get(i).getF().getVx();
            lig++;
            B[lig] = this.noeuds.get(i).getF().getVy();
            lig++;
        }
        return B;
    }

    public double[] resoudreSys() {
        ArrayList<String> Inconnues = this.Inconnues();
        double[] B = this.miseEnEquationForces();
        double[][] Equation = this.miseEnEquationMatrice();
        if (this.noeuds.size() * 2 != Inconnues.size()) {
            throw new Error("Le système n'est pas soluble (la matrice n'est pas carrée)");
        }
        Matrix m = new Matrix(this.noeuds.size() * 2, Inconnues.size());
        for (int i = 0; i < this.noeuds.size() * 2; i++) {
            for (int j = 0; j < Inconnues.size(); j++) {
                m.set(i, j, Equation[i][j]);
            }
        }
        if (m.det() == 0) {
            throw new Error("Le système n'est pas soluble (le determinant est nul");
        }
        double[] v = PivotGauss.resoudreSysteme(Equation, B);
        return v;
    }
    
//Trouver les barres qui risquent de casser    
    public ArrayList<Barre> barreCasse() {
        double[] v = this.resoudreSys();
        ArrayList<Barre> fragile = new ArrayList();
        for (int k = 0; k < this.barres.size(); k++) {
            if (v[k] >= 0) {
                if (v[k] > this.barres.get(k).getCompressionMax()) {
                    fragile.add(this.barres.get(k));
                }
            } else {
                if (abs(v[k]) > this.barres.get(k).getTractionMax()) {
                    fragile.add(this.barres.get(k));
                }
            }
        }
        return fragile;
    }
    
//Permet d'afficher la solution dans la console
    public void afficherSolution() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        double[] v = this.resoudreSys();
        ArrayList<String> Inconnues = this.Inconnues();
        for (int i = 0; i < Inconnues.size(); i++) {
            System.out.println(Inconnues.get(i) + " : " + formatter.format(v[i]));
        }
        System.out.println("");
    }
    
//Remplie une chaine de caracteres avec la matrice et son vecteur des forces, la
//résolution du système, le cout du treillis et les barres susceptible de casser.
    public String calculToString() {
        String s=new String();
        NumberFormat formatter = new DecimalFormat("#0.00");
        double[] v = this.miseEnEquationForces();
        double[][]m=this.miseEnEquationMatrice();
        ArrayList<String> Inconnues = this.Inconnues();
        String Newligne=System.getProperty("line.separator");
        s="Matrice a résoudre et vecteur forces :"+Newligne;
        for (int i = 0; i < this.noeuds.size()*2; i++) {
            for(int j=0;j<this.Inconnues().size();j++){
                s=s+formatter.format(m[i][j])+"   " ;           
            }
            s=s+"      "+formatter.format(v[i])+Newligne;    
        }
        s=s+Newligne+"Solution :"+Newligne;
        double[] w = this.resoudreSys();
        for (int i = 0; i < Inconnues.size(); i++) {
            s=s+Inconnues.get(i) + " : " + formatter.format(w[i])+Newligne+" ";
        }
        s=s+Newligne+"Cout : "+this.coutTreillis()+" € "+Newligne;
        s=s+Newligne+"Barres qui vont casser :"+Newligne;
        for (int i = 0; i < this.barreCasse().size() ; i++) {
            s=s+"Barre "+this.barreCasse().get(i).getId()+Newligne;
        }
        return s;
    }
    
//Renvoie une chaine de caractères contenant les attributs du treillis pour pouvoir
//l'enregister dans un fichier texte
    public String treilliToString(){
        String s;
        String Newligne=System.getProperty("line.separator");
        s="Noeuds :"+Newligne;
        for (int i = 0; i < this.noeuds.size(); i++) {
            s=s+this.noeuds.get(i)+Newligne;
        }
        s=s+"Barres :"+Newligne;
        for (int i = 0; i < this.barreCasse().size() ; i++) {
            s=s+this.barres.get(i)+Newligne;
        }
        return s;
    }
    
//Renvoie la position de la tension de la barre donnée dans la liste des inconnues
    public int numVar(ArrayList<String> inconnues, Barre b) {
        int pos = this.barres.indexOf(b);
        int i = 0;
        while (i < inconnues.size() && !inconnues.get(i).equals("T" + pos)) {
            i++;
        }
        if (i == inconnues.size() - 1) {
            throw new Error("Il n'y a pas d'inconnues suivant cette barre");
        } else {
            return i;
        }
    }

//Renvoie la position de la réaction dans le noeud donnée dans la liste des inconnues
    public int numVar(ArrayList<String> inconnues, Noeud n) {
        int pos = this.noeuds.indexOf(n);
        int i = 0;
        while (i < inconnues.size() && !inconnues.get(i).contains("R" + pos)) {
            i++;
        }
        if (i == inconnues.size()) {
            throw new Error("Il n'y a pas d'inconnues suivant cette barre");
        } else {
            return i;
        }
    }

    public double coutTreillis(){
        double cout=0;
        double y1, y2, x1, x2,longueur;
        for (int i=0;i<this.getBarres().size();i++){
            x1 = this.barres.get(i).getNoeudDepart().getPx(); 
            y1 = this.barres.get(i).getNoeudDepart().getPy(); 
            x2 = this.barres.get(i).getNoeudArrivee().getPx(); 
            y2 = this.barres.get(i).getNoeudArrivee().getPy();
            longueur = java.lang.Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
            cout=cout+(longueur/50)*this.barres.get(i).getCout();
        }
        return cout; 
    }
        
    public Noeud noeudPlusProche(double x, double y, double distMax) {
        if (this.noeuds.isEmpty()) {
            return null;
        } else {
            Noeud nmin = this.noeuds.get(0);
            double distmin = nmin.distance(x, y);
            for (int i = 1; i < this.noeuds.size(); i++) {
                Noeud n = this.noeuds.get(i);
                double dist = n.distance(x, y);
                if (dist < distmin) {
                    distmin = dist;
                    nmin = n;
                }
            }
            if (distmin <= distMax) {
                return nmin;
            } else {
                return null;
            }
        }
    }

    public Group dessine() {
        Group g = new Group();
        for (int i = 0; i < this.noeuds.size(); i++) {
            g.getChildren().add(this.noeuds.get(i).dessine());
        }
        for (int i = 0; i < this.barres.size(); i++) {
            g.getChildren().add(this.barres.get(i).dessine());
        }
        return g;
    }
   }
