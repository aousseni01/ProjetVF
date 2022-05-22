/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.td.interfacegraph;

import fr.insa.papama.tp.Treillis;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
/**
 *
 * @author anyao
 */
public class CalculDialog extends Dialog{
    
    public CalculDialog(Treillis treilli){  
        this.setTitle("Résolution de la matrice");
        this.setContentText(treilli.calculToString());
        ButtonType bOk = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
        this.getDialogPane().getButtonTypes().add(bOk);
    }
}
