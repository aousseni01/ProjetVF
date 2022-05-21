/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.td.interfacegraph;

import static fr.insa.papama.tp.Lire.b;
import fr.insa.papama.tp.PivotGauss;
import fr.insa.papama.tp.Treillis;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javax.swing.JLabel;

/**
 *
 * @author anyao
 */
public class CalculDialog extends Dialog{
    
    public CalculDialog(Treillis treilli){  
        this.setTitle("Résolution de la matrice");
//        Label vect = new Label (PivotGauss.vecteurToString(treilli.miseEnEquationForces()));
//        Label mat = new Label (PivotGauss.affichageMatrice(t));
 //       JLabel syst = new JLabel(treilli.solutionToString());
 //       GridPane grid = new GridPane();
        String Newligne=System.getProperty("line.separator");
        ButtonType bOk = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        this.setContentText("Matrice :"+Newligne+treilli.matriceToString()+Newligne+treilli.solutionToString());
//        this.getDialogPane().setContent(syst);
        this.getDialogPane().getButtonTypes().add(bOk);
    }
}
