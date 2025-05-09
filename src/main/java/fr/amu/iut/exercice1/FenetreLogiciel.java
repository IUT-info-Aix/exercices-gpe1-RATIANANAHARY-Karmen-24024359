package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

        VBox leftBox = new VBox();
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setSpacing(10);

        Label buttonLabel = new Label("Boutons :");

        Button button1 = new Button("Bouton 1");
        Button button2 = new Button("Bouton 2");
        Button button3 = new Button("Bouton 3");
        leftBox.getChildren().addAll(buttonLabel,button1, button2, button3);

        root.setLeft(new HBox(leftBox, new Separator(Orientation.VERTICAL)));

        GridPane grilleFormulaire = new GridPane();
        grilleFormulaire.setAlignment(Pos.CENTER);
        grilleFormulaire.setHgap(10);
        grilleFormulaire.setVgap(10);
        grilleFormulaire.setPadding(new Insets(10));

        grilleFormulaire.addRow(0, new Label("Name:"), new TextField());
        grilleFormulaire.addRow(1, new Label("Email:"), new TextField());
        grilleFormulaire.addRow(2, new Label("Password:"), new TextField());

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);

        buttonBox.getChildren().addAll(new Button("Submit"), new Button("Cancel"));

        grilleFormulaire.add(buttonBox, 0, 3, 2, 1);

        root.setCenter(grilleFormulaire);

        Label statusLabel = new Label("Ceci est un label de bas de page");
        VBox bas = new VBox(new Separator(Orientation.HORIZONTAL),statusLabel);
        bas.setAlignment(Pos.CENTER);
        root.setBottom(bas);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

