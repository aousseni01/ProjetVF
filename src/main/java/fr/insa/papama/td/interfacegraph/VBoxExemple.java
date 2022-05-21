/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.papama.td.interfacegraph;

import fr.insa.papama.tp.Noeud;
import fr.insa.papama.tp.NoeudAppuiDouble;
import fr.insa.papama.tp.Treillis;
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
    private Button noeudCoord;
    private Menu noeud;
    private MenuItem noeudSimple, noeudAppuiSimple, noeudAppuiDouble; 
    private MenuBar bar; 
    private MainPanel main; 
    private Controleur controleur; 
    private DessinPane dessin; 
    private Treillis model;

    
  
  
    
    public VBoxExemple() {
//        List<Button> listedeboutonsH = new ArrayList<>();
//        Button jb5 = new Button ("Créer");
//        listedeboutonsH.add(jb5);
//        Button jb6 = new Button ("Supprimer");
//        listedeboutonsH.add(jb6);
//        this.getChildren().addAll(jb5,jb6);

        this.force = new Button("Ajouter une force"); 
        this.barre = new Button("Créer un segment"); 
        this.getChildren().addAll(this.force, this.barre); 
        
//        this.setSpacing(5);
        FxUtils.setSimpleBorder(this, Color.BLUEVIOLET,1); 

//        this.noeudCoord = new Button("Créer un noeud par coordonées"); 
//                this.noeudCoord.setOnAction((t) -> {
//            this.main.getControleur().ChangerEtat(Controleur.Etat.NOEUD);
//        });
        this.noeud = new Menu("Créer un noeud"); 
        this.noeudAppuiDouble = new MenuItem("Noeud Appui Double"); 
        this.noeudAppuiDouble.setOnAction((t) -> {

        });
        this.noeudAppuiSimple = new MenuItem("Noeud Appui Simple"); 
        this.noeudAppuiSimple.setOnAction((t) -> {
           
        });
        this.noeudSimple = new MenuItem("Noeud Simple"); 
        this.noeudSimple.setOnAction((t) -> {

        });
        
        
           
        noeud.getItems().addAll(noeudSimple, noeudAppuiSimple, noeudAppuiDouble); 
        this.bar = new MenuBar (this.noeud); 
        this.getChildren().add(bar); 

    }

    /**
     * @return the noeudSimple
     */
    public MenuItem getNoeudSimple() {
        return noeudSimple;
    }

    /**
     * @return the noeudAppuiSimple
     */
    public MenuItem getNoeudAppuiSimple() {
        return noeudAppuiSimple;
    }

    /**
     * @return the noeudAppuiDouble
     */
    public MenuItem getNoeudAppuiDouble() {
        return noeudAppuiDouble;
    }

    /**
     * @return the barre
     */
    public Button getBarre() {
        return barre;
    }
    
}

