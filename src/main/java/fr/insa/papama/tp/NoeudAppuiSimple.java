/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

import javafx.scene.Group;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Haimavati
 */
public class NoeudAppuiSimple extends NoeudAppui {
    private double normale;
        
    public NoeudAppuiSimple(double px, double py, Vecteur2D F, int id,double normale){
        super(px,py,F,id);
        this.normale=normale;        
    }
    
    public double getNormale(){
        return normale; 
    }
        
    public void setNormale(double normale) {
        this.normale=normale; 
    }
        
   @Override 
   public String toString(){
       return ("NoeudAppuisSimple"+super.getId()+" = ("+super.getPx()+";"+super.getPy()+"), " +super.getF()+"Angle de la normale"+this.normale); 
   }
   
   @Override
   public Group dessine() {
        Ellipse rep = new Ellipse(this.getPx(), this.getPy(), 4, 6);
         Group l = new Group(rep);
         return l;
       }
    
}
