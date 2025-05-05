package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    private TextField Id;

    @FXML
    private PasswordField pwd;

    @FXML
    private void okClicked() {
        String username = Id.getText();
        String password = pwd.getText();
        System.out.println("Nom d'utilisateur : " + username);
        System.out.println("Mot de passe : " + "*".repeat(password.length()));
    }

    @FXML
    private void cancelClicked() {
        Id.clear();
        pwd.clear();
    }

}