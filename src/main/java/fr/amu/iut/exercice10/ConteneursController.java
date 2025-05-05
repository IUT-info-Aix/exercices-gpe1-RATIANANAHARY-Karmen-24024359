package fr.amu.iut.exercice10;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ConteneursController {

    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;

    @FXML private Button submitButton;
    @FXML private Button cancelButton;
    @FXML private Button bouton1;
    @FXML private Button bouton2;
    @FXML private Button bouton3;

    @FXML
    public void initialize() {
        submitButton.setOnAction(e -> {
            System.out.println("Submit clicked");
            System.out.println("Name: " + nameField.getText());
            System.out.println("Email: " + emailField.getText());
            System.out.println("Password: " + passwordField.getText());
        });

        cancelButton.setOnAction(e -> {
            nameField.clear();
            emailField.clear();
            passwordField.clear();
        });

        bouton1.setOnAction(e -> System.out.println("Bouton 1 cliqué"));
        bouton2.setOnAction(e -> System.out.println("Bouton 2 cliqué"));
        bouton3.setOnAction(e -> System.out.println("Bouton 3 cliqué"));
    }
}
