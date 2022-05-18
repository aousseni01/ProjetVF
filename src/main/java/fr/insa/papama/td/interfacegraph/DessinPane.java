/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.td.interfacegraph;


import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Haimavati
 */
public class DessinPane extends Pane {
    
    private MainPanel main; 

     public void redrawAll() {
        this.getChildren().clear();
        this.getChildren().add(this.main.getModel().dessine());
    }
     
    public DessinPane(MainPanel main) {
        super();
        Rectangle clip = new Rectangle();
        clip.heightProperty().bind(this.heightProperty());
        clip.widthProperty().bind(this.widthProperty());
        this.setClip(clip);
        this.main = main;
//        FxUtils.setSimpleBorder(this, Color.BLUEVIOLET, 1);
        this.setOnMouseClicked((t) -> {
            this.main.getControleur().clicDansDessin(t);
            this.redrawAll();
        });
        this.redrawAll();
    }
    
    
  
}
