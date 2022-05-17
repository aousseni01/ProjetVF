/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;

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
    
}
