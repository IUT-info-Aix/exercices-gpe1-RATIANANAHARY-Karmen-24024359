package com.example.partie2;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class BonjourFenetre extends Application {

    // Label affichant le message de bienvenue
    private Label helloLabel;

    // Champ de saisi du nom de l'utilisateur
    private TextField nameField;

    // Bouton déclenchant la mise à jour du texte
    private Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création d'un conteneur VBox avec ses éléments centrés
        VBox vbox = new VBox(15); // Espace entre les éléments
        vbox.setAlignment(Pos.CENTER);

        // Création et ajout du label
        this.helloLabel = new Label("Bonjour à tous !");
        vbox.getChildren().add(helloLabel);

        // Création et ajout du champ de saisie
        this.nameField = new TextField("Veuillez saisir un nom");
        nameField.setMaxWidth(180.0d);
        nameField.setFont(Font.font("Courier", FontWeight.NORMAL, 12));
        vbox.getChildren().add(nameField);

        // Ajout d'un gestionnaire pour appuyer sur "Entrée" dans le champ texte
        nameField.setOnAction(actionEvent -> handleButtonClick(actionEvent));

        // Création du bouton
        this.button = new Button();

        // Chargement et affectation de l'image au bouton
        Image image = new Image(BonjourFenetre.class.getResource("/com.example/silver_button.png").toString());
        ImageView iv = new ImageView(image);
        button.setGraphic(iv);

        // Ajout du bouton dans le conteneur
        vbox.getChildren().add(button);

        // Ajout du gestionnaire d'évènement sur le bouton
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleButtonClick(event));

        // Création de la scène
        Scene scene = new Scene(vbox);

        // Configuration de la fenêtre
        primaryStage.setTitle("Hello application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Méthode appelée lors d'un clic bouton ou touche entrée
    private void handleButtonClick(Event event) {
        helloLabel.setText("Bonjour à toi, " + nameField.getText());
    }
}
