/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

import java.util.ArrayList;

/**
 *
 * @author Haimavati
 */
public abstract class Noeud {
    
    //Attributs 
    private int id; 
    private double px, py; 
    private Vecteur2D F; 
    private ArrayList<Barre> barresDepart = new ArrayList();
    private ArrayList<Barre> barresArrivee = new ArrayList();
    

    // Encapsulation 
    public double getPx(){
        return px; 
    }
        
    public void setPx(int px) {
        this.px=px; 
    }
    
    public double getPy() {
        return py;
    }
    
    public void setPy(int py){
        this.py=py; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vecteur2D getF() {
        return F;
    }
   
    public void setF(Vecteur2D F) {
        this.F = F;
    }
    public ArrayList<Barre> getBarresDepart() {
        return barresDepart;
    }

    public ArrayList<Barre> getBarresArrivee() {
        return barresArrivee;
    }

    
    //Constructeur permettant de fixer les attributs 
    public Noeud(double px, double py, Vecteur2D F, int id){
        this.px=px; 
        this.py=py; 
        this.F=F; 
        this.id=id;
        this.barresArrivee=new ArrayList<>();
        this.barresDepart=new ArrayList<>();
    }

    //Constructeur permettant de fixer uniquement la position et la force
    public Noeud(double px, double py, Vecteur2D F){
        this(px,py,F,-1);
    }
    
    //Constructeur permettant de fixer uniquement la position 
    public Noeud(double px, double py){
        this(px,py,new Vecteur2D(0, 0));
    }
    
    @Override
    public String toString(){
        return ("Noeud n°"+id+" = ("+px+";"+py+"), " + "force associée =>"+F); 
    }
    
//    Méthode permettant à l'utilisateur d'entrer les caractéristiques d'un noeud
    public static Noeud entreeNoeud () {
        double x,y;
        int id;
        id = -1; 
        Noeud n; 
        System.out.println("Indiquer le type du noeud à créer: noeud simple: 1 , noeud appui simple: 2 ou noeud appui double: 3");
        int type = Lire.i(); 
        if (type != 1 && type !=2 && type !=3) {
            throw new Error ("Vous avez mal entré le type du noeud désiré");
        }
        System.out.println("Entrez les coordonnées du noeud:");
        x=Lire.d();        
        y=Lire.d();
        System.out.println("Entrez le vecteur force associé au noeud");
        double vx=Lire.d(); 
        double vy=Lire.d(); 
        Vecteur2D F = new Vecteur2D(vx,vy);  
        switch (type) {
            case 2:
                System.out.println("Donnez l'angle de la normale avec l'axe Ox");
                double normale=Lire.d();                       
                n = new NoeudAppuiSimple(x,y,F,id,normale);
                break;
            case 3:
                n = new NoeudAppuiDouble(x,y,F,id);
                break;
            default: 
                n = new NoeudSimple(x,y,F,id);
                break;
        }
        return n;
        
    }
    public int nbrInconnues(){
        if (this instanceof NoeudAppuiSimple){
            return 1;
        }else if (this instanceof NoeudAppuiDouble){
            return 2;
        }else
            return 0;
    }
    public ArrayList<Barre> barresIncidentes(){
        ArrayList<Barre> barresIncidentes = new ArrayList();
        barresIncidentes.addAll(this.getBarresArrivee());
        barresIncidentes.addAll(this.getBarresDepart());
        return barresIncidentes;
    }

}
