package com.example.exercice12;

import com.example.exercice12.CustomButton;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Palette extends Application {

    // Attribut pour retenir le dernier bouton cliqué
    private CustomButton sourceOfEvent;
    private Label texteDuHaut;
    private Label texteDuBas;
    private Pane panneau;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPrefSize(400, 300);

        // Label du haut
        texteDuHaut = new Label("Cliquez sur un bouton pour commencer.");
        texteDuHaut.setPadding(new Insets(8));
        texteDuHaut.setStyle("-fx-font-size: 18px;");

        // Label du bas
        texteDuBas = new Label();
        texteDuBas.setPadding(new Insets(8));
        texteDuBas.setStyle("-fx-font-size: 14px;");

        // Panneau central
        panneau = new Pane();
        panneau.setStyle("-fx-background-color: white;");
        root.setCenter(panneau);

        // Empiler les deux labels en haut
        VBox topBox = new VBox(texteDuHaut, texteDuBas);
        topBox.setAlignment(Pos.CENTER);
        root.setTop(topBox);

        // Création des CustomButtons
        CustomButton boutonVert = new CustomButton("Vert", Color.web("#46c682"));
        CustomButton boutonRouge = new CustomButton("Rouge", Color.web("#bd3636"));
        CustomButton boutonBleu = new CustomButton("Bleu", Color.web("#1883cf"));

        // Gestionnaire d'événement générique
        javafx.event.EventHandler<javafx.event.ActionEvent> gestionnaireEvennement = event -> {
            CustomButton bouton = (CustomButton) event.getSource();
            sourceOfEvent = bouton;
            bouton.setNbClics(bouton.getNbClics() + 1);  // incrémentation compteur
        };

        // Affectation du gestionnaire aux boutons
        boutonVert.setOnAction(gestionnaireEvennement);
        boutonRouge.setOnAction(gestionnaireEvennement);
        boutonBleu.setOnAction(gestionnaireEvennement);

        // Listener pour nbClics
        ChangeListener<Number> nbClicsListener = new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (sourceOfEvent != null) {
                    String nom = sourceOfEvent.getText();
                    texteDuHaut.setText("Bouton " + nom + " cliqué !");
                    texteDuBas.setText("Nombre de clics : " + newValue);
                    panneau.setStyle("-fx-background-color: " + toRgbCode(sourceOfEvent.getCouleur()) + ";");
                }
            }
        };

        // Ajout des listeners
        boutonVert.nbClicsProperty().addListener(nbClicsListener);
        boutonRouge.nbClicsProperty().addListener(nbClicsListener);
        boutonBleu.nbClicsProperty().addListener(nbClicsListener);

        // Placement des boutons
        HBox boutons = new HBox(10, boutonVert, boutonRouge, boutonBleu);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10));
        root.setBottom(boutons);

        // Affichage
        Scene scene = new Scene(root);
        primaryStage.setTitle("Palette - Exercice 12");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Convertit une couleur JavaFX en code hexadécimal CSS
    private String toRgbCode(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
