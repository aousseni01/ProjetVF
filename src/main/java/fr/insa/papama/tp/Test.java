/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.tp;
import java.util.ArrayList;

/**
 * MAIN PROGRAMME 
 * @author Haimavati
 */
public class Test {
    
    
    public static void main(String[] args) {            
    Treillis t= new Treillis();
    t=Treillis.treilliTest();
    ArrayList<Barre> barreQuiCasse = new ArrayList();
    barreQuiCasse=t.barreCasse();
    for (int i=0;i<barreQuiCasse.size();i++){
        System.out.println(barreQuiCasse.get(i));
    }
    
        
    }
    
    
}
