/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.papama.td.interfacegraph;

import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author aousseni01
 */
public class VBoxExemple extends VBox {
    
    private Button force; 
    private Button barre; 
    private Menu noeud;
    private MenuItem noeudSimple, noeudAppuiSimple, noeudAppuiDouble; 
    private MenuBar bar; 
    
  
  
    
    public VBoxExemple() {
//        List<Button> listedeboutonsH = new ArrayList<>();
//        Button jb5 = new Button ("Créer");
//        listedeboutonsH.add(jb5);
//        Button jb6 = new Button ("Supprimer");
//        listedeboutonsH.add(jb6);
//        this.getChildren().addAll(jb5,jb6);

        this.force = new Button("Créer un point"); 
        this.barre = new Button("Créer un segment"); 
        this.getChildren().addAll(this.force, this.barre); 
        
//        this.setSpacing(5);
        FxUtils.setSimpleBorder(this, Color.BLUEVIOLET,1); 

        
        this.noeud = new Menu("Créer un noeud"); 
        this.noeudAppuiDouble = new MenuItem("Noeud Appui Double"); 
        this.noeudAppuiSimple = new MenuItem("Noeud Appui Simple"); 
        this.noeudSimple = new MenuItem("Noeud Simple"); 
           
        noeud.getItems().addAll(noeudSimple, noeudAppuiSimple, noeudAppuiDouble); 
        this.bar = new MenuBar (this.noeud); 
        this.getChildren().add(bar); 

    }
}

