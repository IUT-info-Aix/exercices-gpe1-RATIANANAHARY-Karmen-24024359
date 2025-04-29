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

    private Label helloLabel;

    private TextField nameField;

    private Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox(15); // Espace de 15px entre les éléments
        vbox.setAlignment(Pos.CENTER);

        this.helloLabel = new Label("Bonjour à tous !");
        vbox.getChildren().add(helloLabel);

        this.nameField = new TextField("Veuillez saisir un nom");
        nameField.setMaxWidth(180.0d);
        nameField.setFont(Font.font("Courier", FontWeight.NORMAL, 12));
        vbox.getChildren().add(nameField);

        nameField.setOnAction(actionEvent -> handleButtonClick(actionEvent));

        // Ajout d'un bouton avec du texte
        Button button = new Button();
        vbox.getChildren().add( button );

        // Chargement de l'image
        Image image = new Image( BonjourFenetre.class.getResource("/com.example/silver_button.png").toString() );

        // Création d'un composant avec l'image peinte à l'intérieur
        ImageView iv = new ImageView();
        iv.setImage(image);

        // Intégration de l'image dans le bouton
        button.setGraphic( iv );

        button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> handleButtonClick(event));

        Scene scene = new Scene(vbox);

        primaryStage.setTitle("Hello application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonClick(Event event) {
        helloLabel.setText("Bonjour à toi, " + nameField.getText());
    }
}
