/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;


/**
 *
 * @author Haimavati
 */
public class NoeudAppuiDouble extends NoeudAppui {
    
        public NoeudAppuiDouble (double px, double py, Vecteur2D F, int id){
        super(px,py,F,id);
    }
    
      
        

    @Override
    public String toString(){
        return ("NoeudAppuiDouble"+super.getId()+" = ("+super.getPx()+";"+super.getPy()+"), " +super.getF()); 
    }
    
    
    @Override
    public Group dessine() {
        Rectangle rep = new Rectangle(this.getPx(), this.getPy(), 6, 3);
         Group l = new Group(rep);
         return l;
       }
}
