/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

import static java.lang.Math.atan;

/**
 *
 * @author Haimavati
 */
public class Barre {
    
    //Attributs 
    private int id; 
    private Noeud noeudDepart, noeudArrivee; 
    private double tractionMax, compressionMax, cout; 

    //Constructeur
    public Barre(int id, Noeud noeudDepart, Noeud noeudArrivee, double tractionMax,double compressionMax, double cout) {
        this.id=id; 
        this.noeudDepart=noeudDepart;
        noeudDepart.getBarresDepart().add(this);
        this.noeudArrivee=noeudArrivee; 
        noeudArrivee.getBarresArrivee().add(this);
        this.tractionMax=tractionMax;
        this.compressionMax=compressionMax; 
        this.cout=cout;
    }
    
    //Méthode toString
    @Override
    public String toString() {
        return ("Barre"+id+" = "+noeudDepart+" ; "+"noeudArrivee. Traction max = "+tractionMax+ "; Compression max = "+compressionMax+"; Coût = "+cout); 
    }
    
//  ENCAPSULATION
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the noeudDepart
     */
    public Noeud getNoeudDepart() {
        return noeudDepart;
    }

    /**
     * @param noeudDepart the noeudDepart to set
     */
    public void setNoeudDepart(Noeud noeudDepart) {
        this.noeudDepart = noeudDepart;

    }

    /**
     * @return the noeudArrivee
     */
    public Noeud getNoeudArrivee() {
        return noeudArrivee;
    }

    /**
     * @param noeudArrivee the noeudArrivee to set
     */
    public void setNoeudArrivee(Noeud noeudArrivee) {
        this.noeudArrivee = noeudArrivee;
    }

    /**
     * @return the tractionMax
     */
    public double getTractionMax() {
        return tractionMax;
    }

    /**
     * @param tractionMax the tractionMax to set
     */
    public void setTractionMax(double tractionMax) {
        this.tractionMax = tractionMax;
    }

    /**
     * @return the compressionMax
     */
    public double getCompressionMax() {
        return compressionMax;
    }

    /**
     * @param compressionMax the compressionMax to set
     */
    public void setCompressionMax(double compressionMax) {
        this.compressionMax = compressionMax;
        
    }

    /**
     * @return the cout
     */
    public double getCout() {
        return cout;
    }

    /**
     * @param cout the cout to set
     */
    public void setCout(double cout) {
        this.cout = cout;
    }
    
    
// Méthode qui renvoie le noeud opposé au noeud rentré
   public Noeud noeudOppose (Noeud n) {
       Noeud nopp;
       if (n.getId()!=this.getNoeudArrivee().getId() && n.getId()!=this.getNoeudDepart().getId()){
           throw new Error ("Le noeud entré ne correspond pas à la barre entrée");
       }
       if (n.getId()==this.getNoeudArrivee().getId()){
           nopp=this.getNoeudDepart();
       }
       else 
           nopp=this.getNoeudArrivee();
       return nopp; 
       }
   
    
////    Méthode qui calcule l'angle 
    public  double Angle (Noeud n) {
        double y1, y2, x1, x2;
        Noeud nopp=this.noeudOppose(n);
        x1 = n.getPx(); 
        y1 = n.getPy(); 
        x2 = nopp.getPx(); 
        y2 = nopp.getPy(); 
               
        double angle = atan((y2-y1)/(x2-x1)); 
        return angle; 
    }
    
}
