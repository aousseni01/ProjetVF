 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.papama.td.interfacegraph;

import fr.insa.papama.tp.Treillis;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author aousseni01
 */


public class HBoxExemple extends HBox {
    
  private Button enregistrer; 
  private Button supprimer; 
  private Stage stage; 
  private Treillis treillis; 
  private File fichierCourant; 
  
  
    
    public HBoxExemple() {
//        List<Button> listedeboutonsH = new ArrayList<>();
//        Button jb5 = new Button ("Créer");
//        listedeboutonsH.add(jb5);
//        Button jb6 = new Button ("Supprimer");
//        listedeboutonsH.add(jb6);
//        this.getChildren().addAll(jb5,jb6);

        this.enregistrer = new Button("Enregistrer"); 
        this.enregistrer.setOnAction((t) -> {
            System.out.println("Clic sur le Bouton Enregistrer");
            saveAs(); 
        });
        this.supprimer = new Button("Supprimer"); 
        this.supprimer.setOnAction((t) -> {
            System.out.println("Clic sur le Bouton Supprimer");
        }); 
//        this.setSpacing(5);
        this.getChildren().addAll(this.enregistrer, this.supprimer); 
        
        FxUtils.setSimpleBorder(this, Color.BLUEVIOLET,1); 

    }
    
     public void saveAs() {
       FileChooser chooser = new FileChooser();
       File f = chooser.showSaveDialog(this.stage);
       if (f != null) {
           save(f);
       }
   }

   private void save(File f) {
       try (BufferedWriter bout = new BufferedWriter(new FileWriter(f))) {
           treillis.save(bout);
           this.fichierCourant = f;
       } catch (IOException ex) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Erreur");
           alert.setHeaderText("Problème durant la sauvegarde");
           alert.setContentText(ex.getLocalizedMessage());
           alert.showAndWait();
       }
   }
}
