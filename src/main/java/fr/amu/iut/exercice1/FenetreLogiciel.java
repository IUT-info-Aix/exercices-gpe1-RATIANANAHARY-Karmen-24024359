package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FenetreLogiciel extends Application {

     @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();



        Menu menuFile = new Menu("File");
        MenuItem itemFileNew = new MenuItem("New");
        MenuItem itemFileOpen = new MenuItem("Open");
        MenuItem itemFileSave = new MenuItem("Save");
        MenuItem itemFileClose = new MenuItem("Close");
        SeparatorMenuItem separateur1 = new SeparatorMenuItem();
        SeparatorMenuItem separateur2 = new SeparatorMenuItem();
        SeparatorMenuItem separateur3 = new SeparatorMenuItem();
        menuFile.getItems().addAll(itemFileNew, separateur1, itemFileOpen, separateur2, itemFileSave,separateur3, itemFileClose);

        Menu menuEdit = new Menu("Edit");
        MenuItem itemEditCut = new MenuItem("Cut");
        MenuItem itemEditCopy = new MenuItem("Copy");
        MenuItem itemEditPaste = new MenuItem("Paste");
        SeparatorMenuItem separateur4 = new SeparatorMenuItem();
        SeparatorMenuItem separateur5 = new SeparatorMenuItem();
        menuEdit.getItems().addAll(itemEditCut, separateur4, itemEditCopy,separateur5, itemEditPaste);

        Menu menuHelp = new Menu("Help");

        MenuBar menuBar = new MenuBar(menuFile, menuEdit, menuHelp);
        root.setTop(menuBar);

        VBox partieGauche = new VBox();
        Label titreBouton = new Label("Boutons :");
        Button bouton1 = new Button("Bouton1");
        Button bouton2 = new Button("Bouton2");
        Button bouton3 = new Button("Bouton3");
        partieGauche.getChildren().addAll(titreBouton, bouton1, bouton2, bouton3);

        root.setLeft(partieGauche);

        Label footer = new Label("Ceci est un label de bas de page");
        root.setBottom(footer);


        GridPane formulaire = new GridPane();
        Label name = new Label("Nom :");
        Label email = new Label("Email :");
        Label password = new Label("Password :"); //finir le formulaire

        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

