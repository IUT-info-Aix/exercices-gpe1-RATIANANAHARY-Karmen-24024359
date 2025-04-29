package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Palette extends Application {

    private int compteurVert = 0;
    private int compteurRouge = 0;
    private int compteurBleu = 0;
    private Label label;
    private Pane panneau;

    @Override
    public void start(Stage primaryStage) {
        // Création du BorderPane
        BorderPane root = new BorderPane();
        root.setPrefSize(400, 300);

        // Label en haut
        label = new Label();
        BorderPane.setAlignment(label, Pos.CENTER);
        label.setPadding(new Insets(8));
        label.setFont(Font.font(20));
        root.setTop(label);

        // Pane au centre
        panneau = new Pane();
        panneau.setStyle("-fx-background-color: white;");
        root.setCenter(panneau);

        // Boutons en bas
        Button boutonVert = new Button("Vert");
        Button boutonRouge = new Button("Rouge");
        Button boutonBleu = new Button("Bleu");

        boutonVert.setOnAction(e -> {
            compteurVert++;
            panneau.setStyle("-fx-background-color: #46c682;");
            label.setText("Vert choisi " + compteurVert + " fois");
        });

        boutonRouge.setOnAction(e -> {
            compteurRouge++;
            panneau.setStyle("-fx-background-color: #bd3636;");
            label.setText("Rouge choisi " + compteurRouge + " fois");
        });

        boutonBleu.setOnAction(e -> {
            compteurBleu++;
            panneau.setStyle("-fx-background-color: #1883cf;");
            label.setText("Bleu choisi " + compteurBleu + " fois");
        });

        HBox boutons = new HBox(10, boutonVert, boutonRouge, boutonBleu);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10));
        root.setBottom(boutons);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
