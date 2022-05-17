/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;


/**
 *
 * @author Haimavati
 */
public class Vecteur2D {
    
    // Atributs 
    private double vx; 
    private double vy; 
    
    // Constructeur 
    public Vecteur2D (double vx, double vy) {
        this.vx = vx; 
        this.vy = vy;      
    }
    
    //Encapsulation
    public double getVx(){
        return vx;
    }
    
    public void setVx(double vx) {
        this.vx=vx;
    }
    
    public double getVy() {
        return vy; 
    }
    
    public void setVy(double vy) {
        this.vy = vy; 
    }
    
    //Methode toString
    @Override
    public String toString() {
        return "(" + this.vx + ";" + this.vy + ")";
    }
   
  
}
