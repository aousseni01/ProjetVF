/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.td.interfacegraph;

import static fr.insa.papama.tp.Lire.b;
import fr.insa.papama.tp.PivotGauss;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 *
 * @author anyao
 */
public class CalculDialog extends Dialog<PivotGauss>{
//    private PivotGauss vecteur;
//    private PivotGauss matrice;
//    private PivotGauss systeme;
//    
    public CalculDialog(PivotGauss calcul, MouseEvent t){   
        this.setTitle("Résolution de la matrice");
//        Label vect = new Label (PivotGauss.affichageVecteur(t));
//        Label mat = new Label (PivotGauss.affichageMatrice(t));
//        Label syst = new Label (PivotGauss.resoudreSysteme(a, b));
        GridPane grid = new GridPane();
        ButtonType bOk = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().setContent(grid);
        this.getDialogPane().getButtonTypes().add(bOk);
    }
}
