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
public abstract class NoeudAppui extends Noeud {
    
        public NoeudAppui (double px, double py, Vecteur2D F, int id){
        super(px,py,F,id);
    }
        @Override
        public Group dessine() {
        Ellipse rep = new Ellipse(this.getPx(), this.getPy(), 5, 8);
         Group l = new Group(rep);
         return l;
       }
}

