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

        this.force = new Button("Ajouter une force"); 
        this.barre = new Button("Créer une barre");
        this.barre.setOnAction((t) -> {
            this.main.getControleur().ChangerEtat(Controleur.Etat.BARRE1);
        });
        
        this.getChildren().addAll(this.force, this.barre); 
        

        
        FxUtils.setSimpleBorder(this, Color.BLUEVIOLET,1); 


        this.noeud = new Menu("Créer un noeud"); 
        this.noeudAppuiDouble = new MenuItem("Noeud Appui Double"); 
        this.noeudAppuiDouble.setOnAction((t) -> {
            System.out.println("Noeud Appui Double");
            this.main.getControleur().ChangerEtat(Controleur.Etat.NOEUD);
        });
        this.noeudAppuiSimple = new MenuItem("Noeud Appui Simple"); 
        this.noeudAppuiSimple.setOnAction((t) -> {
            System.out.println("Noeud Appuis Simple");
            this.main.getControleur().ChangerEtat(Controleur.Etat.NOEUD);

        });
        this.noeudSimple = new MenuItem("Noeud Simple"); 
        this.noeudSimple.setOnAction((t) -> {
            System.out.println("Noeud Simple");
            this.main.getControleur().ChangerEtat(Controleur.Etat.NOEUD);

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
    
    public MainPanel getMain() {
        return main; 
    }
    
    public void setMain(MainPanel main) {
        this.main = main; 
    }
}

