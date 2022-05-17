/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.td.interfacegraph;

import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Haimavati
 */
public class BorderPaneExemple extends BorderPane {
    public BorderPaneExemple() {
        List<Button> bs = CompoTestSets.BoutonsV().subList(0, 5); 
        this.setTop(bs.get(0)); 
        this.setLeft(bs.get(1)); 
        this.setRight(bs.get(2)); 
        this.setCenter(bs.get(3)); 
        this.setBottom(bs.get(4));
    }
}
