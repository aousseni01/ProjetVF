/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.insa.papama.td.interfacegraph;

import fr.insa.papama.tp.Barre;
import fr.insa.papama.tp.Noeud;
import fr.insa.papama.tp.Treillis;
import java.util.List;
import java.util.Optional;
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
    private Treillis model;
    private Controleur control;
    private List<Barre> barreProbleme;
    private Button creationNoeud;
    private Button calculTout;
    
    public MainPanel(Treillis model) {
        this.control = new Controleur(this);
        this.model = model;
        this.outilsTop = new HBoxExemple();
        this.outilsLeft = new VBoxExemple(); 
        this.dessin = new DessinPane(this);
        this.setCenter(this.dessin);
        this.setTop(this.outilsTop);
        this.setLeft(this.outilsLeft);
        this.creationNoeud = new Button("creation noeud");
        this.creationNoeud.setOnAction((t) -> {
            NoeudDialog dialog = new NoeudDialog();
            Optional<Noeud> res = dialog.showAndWait();
            if (res.isPresent()) {
                Noeud n = res.get();
                this.model.ajouteNoeud(n);
                this.dessin.redrawAll();
            }
        });
        this.setBottom(this.creationNoeud);
        this.calculTout = new Button("calcul tout");
        this.calculTout.setOnAction((t) -> {
           CalculDialog dialog1 = new CalculDialog(this.model);
           dialog1.showAndWait();
//       this.barreProbleme = this.model.creaMatrice();
           
//           this.barreProbleme.addAll(this.model.barreCasse());
//           System.out.println(this.barreProbleme);
           this.dessin.redrawAll();
       });
       this.setRight(this.calculTout);
    }
    
    public Treillis getModel(){
        return this.model;
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
