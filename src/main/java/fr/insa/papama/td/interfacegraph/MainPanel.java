/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.papama.td.interfacegraph;

import fr.insa.papama.tp.Treillis;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author aousseni01
 */
public class MainPanel extends BorderPane{
    private HBoxExemple outilsTop;
    private VBoxExemple outilsLeft;
    private DessinPane dessin;
    private Treillis model;
    private Controleur control;
    
    public MainPanel(Treillis model) {
        this.control = new Controleur(this);
        this.model = model;
        this.outilsTop = new HBoxExemple();
        this.outilsLeft = new VBoxExemple(); 
        this.dessin = new DessinPane(this);
        this.setCenter(this.dessin);
        this.setTop(this.outilsTop);
        this.setLeft(this.outilsLeft);
    }
    public Treillis getModel(){
        return model;
    }

    /**
     * @return the outilsTop
     */
    public HBoxExemple getOutilsTop() {
        return outilsTop;
    }

    /**
     * @return the outilsLeft
     */
    public VBoxExemple getOutilsLeft() {
        return outilsLeft;
    }

    public Controleur getControleur(){
        return control;
    }

    public void redrawAll(){
        this.dessin.redrawAll();
    }
}
