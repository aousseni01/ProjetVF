/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.papama.td.interfacegraph;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;

/**
 *
 * @author aousseni01
 */
public class CompoTestSets {
    public static List<Button> BoutonsV() {
        List<Button> listedeboutonsV = new ArrayList<>();
        Button jb1 = new Button("Barre");
        listedeboutonsV.add(jb1);
        Button jb2 = new Button("Noeud libre");
        listedeboutonsV.add(jb2);
        Button jb3 = new Button("Noeud appui simple");
        listedeboutonsV.add(jb3);
        Button jb4 = new Button("Noeud appui double");
        listedeboutonsV.add(jb4);
        return listedeboutonsV;
    }
    public static List<Button> BoutonsH() {
        List<Button> listedeboutonsH = new ArrayList<>();
        Button jb5 = new Button ("Créer");
        listedeboutonsH.add(jb5);
        Button jb6 = new Button ("Supprimer");
        listedeboutonsH.add(jb6);
        return listedeboutonsH;
    }
}
