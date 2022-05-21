package fr.insa.papama.td.interfacegraph;

import fr.insa.papama.tp.Treillis;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX Projet_Treillis
 */
public class Projet_Treillis extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Treillis");
//        MainPanel main = new MainPanel();
        Treillis treilli = new Treillis();
        treilli = Treillis.treilliTest();
        Scene scene = new Scene(new MainPanel(treilli),850 , 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}