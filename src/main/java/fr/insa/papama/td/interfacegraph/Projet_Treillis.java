package fr.insa.papama.td.interfacegraph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX Projet_Treillis
 */
public class Projet_Treillis extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Treillis");
        MainPanel main = new MainPanel();
        Scene scene = new Scene(new MainPanel(),850 , 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}