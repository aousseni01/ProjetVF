/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.td.interfacegraph;

import fr.insa.papama.tp.Noeud;
import fr.insa.papama.tp.NoeudSimple;
import fr.insa.papama.tp.Vecteur2D;
import java.util.Optional;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Haimavati
 */

public class NoeudDialog extends Dialog<Noeud> {
   private Noeud noeud;

   private TextField px;
   private TextField py;
   private TextField vx;
   private TextField vy;

   public NoeudDialog(Noeud noeud, MouseEvent t){
       if (noeud != null) {
           this.px = new TextField(Double.toString(noeud.getPx()));
           this.py = new TextField(Double.toString(noeud.getPy()));
           this.vx = new TextField(Double.toString(noeud.getF().getVx()));
           this.vy = new TextField(Double.toString(noeud.getF().getVy()));
       } else {
           this.px = new TextField(Double.toString(t.getX()));
           this.py = new TextField(Double.toString(t.getY()));
           this.vx = new TextField("0.0");
           this.vy = new TextField("0.0");
       }
       this.noeud = noeud;
       this.setTitle("Créer un noeud avec les ses caractéristiques");
       Label lPx = new Label("px:");
       Label lPy = new Label("py:");
       Label lFPx = new Label("Composante de la force appliquée vx:");
       Label lFPy = new Label("Composante de la force appliquée vy:");

       GridPane grid = new GridPane();
       grid.add(lPx, 0, 0);
       grid.add(px, 1, 0);
       grid.add(lPy, 0, 1);
       grid.add(py, 1, 1);
       grid.add(lFPx, 0, 2);
       grid.add(vx, 1, 2);
       grid.add(vy, 0, 3);
       grid.add(vy, 1, 3);

       ButtonType bOk = new ButtonType("Ok", ButtonData.OK_DONE);
       ButtonType bAnnuler = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
       this.getDialogPane().setContent(grid);
       this.getDialogPane().getButtonTypes().add(bOk);
       this.getDialogPane().getButtonTypes().add(bAnnuler);

       this.setResultConverter((p) -> {
           if (p == bOk) {
               double px, py, vx, vy;
               try {
                   px = Double.parseDouble(this.px.getText());
                   py = Double.parseDouble(this.py.getText());
                   vx = Double.parseDouble(this.vx.getText());
                   vy = Double.parseDouble(this.vy.getText());
               } catch (NumberFormatException e){
                   return null;
               }
               return new NoeudSimple(px, py, new Vecteur2D(vx,vy),0);
           } else {
               return null;
           }
       });
   }
}
