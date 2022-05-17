/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.papama.td.interfacegraph;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author aousseni01
 */
public class MainPanel extends BorderPane{
    private HBoxExemple outilsTop;
    private VBoxExemple outilsLeft;
    private DessinPane dessin;
    
    public MainPanel() {
        this.outilsTop = new HBoxExemple();
        this.outilsLeft = new VBoxExemple(); 
        this.dessin = new DessinPane(this);
        this.setCenter(this.dessin);
        this.setTop(this.outilsTop);
        this.setLeft(this.outilsLeft);
    }



}
