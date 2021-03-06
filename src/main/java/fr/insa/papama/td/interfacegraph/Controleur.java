/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.papama.td.interfacegraph;

import fr.insa.papama.tp.Barre;
import fr.insa.papama.tp.Noeud;
import java.util.Optional;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author anyao
 */
public class Controleur {
   private MainPanel main;
   private Noeud noeudSelect;
   public enum Etat { SELECT, NOEUD, BARRE1, BARRE2 }

   private Etat etat;

   public Controleur(MainPanel main) {
       this.main = main;
       this.etat = Etat.SELECT;
   }

   public void clicDansDessin(MouseEvent t) {
       Noeud n;
       switch (this.etat) {
           case NOEUD:
               //n = new NoeudSimple(t.get), t.getY());
               n = this.main.getModel().noeudPlusProche(t.getX(), t.getY(), 5);
               boolean creerNoeud = n==null;
               NoeudDialog dialog = new NoeudDialog(n, t);
               Optional<Noeud> p = dialog.showAndWait();
               if (p.isPresent()){
                   if (creerNoeud) {
                       n = p.get();
                       this.main.getModel().ajouteNoeud(n);
                   } else {
                       n.setPx(p.get().getPx());
                       n.setPy(p.get().getPy());
                       n.setF(p.get().getF());
                   }
                   //this.ChangerEtat(Etat.SELECT);
               }
               break;
           case SELECT:
               n = this.main.getModel().noeudPlusProche(t.getX(), t.getY(), 5);
               if (n != null){
                   if (noeudSelect != null)
//                    noeudSelect.setColor(Color.BLACK);
                    noeudSelect = n;
//                    noeudSelect.setColor(Color.RED);
               } else {
                   if (noeudSelect != null){
                     //  noeudSelect.setColor(Color.BLACK);
                       noeudSelect = null;
                   }
               }
               break;
           case BARRE1:
               n = this.main.getModel().noeudPlusProche(t.getX(), t.getY(), 5);
               if (n != null){
                   if (noeudSelect != null)
//                       noeudSelect.setColor(Color.BLACK);
                   System.out.println("Test");
                   noeudSelect = n;
//                       noeudSelect.setColor(Color.RED);
                   this.ChangerEtat(Etat.BARRE2);
               }
               break;
           case BARRE2:
               n = this.main.getModel().noeudPlusProche(t.getX(), t.getY(), 5);
               if (n != null){
                   this.main.getModel().ajouteBarre(new Barre(this.noeudSelect, n));
//                   this.noeudSelect.setColor(Color.BLACK);
                   this.noeudSelect = null;
                   this.ChangerEtat(Etat.SELECT);
               }
               break;
           default:
               throw new AssertionError();
       }
   }

   public void ChangerEtat(Etat nouvelEtat){
       switch (nouvelEtat) {
//           case SELECT:
//               this.etat = nouvelEtat;
//               this.main.getOutilsLeft().getNoeudDou().setSelected(true);
//               break;
           case NOEUD:
               this.etat = nouvelEtat;
               this.main.getOutilsLeft().getNoeudSimple();
               break;
           case BARRE1:
               this.etat = nouvelEtat;
               break;
           case BARRE2:
               this.etat = nouvelEtat;
               break;
           default:
               throw new AssertionError();
       }
       this.main.redrawAll();
   }
}
