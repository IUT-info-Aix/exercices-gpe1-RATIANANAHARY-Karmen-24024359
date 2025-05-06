package fr.amu.iut.exercice9;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        CustomButton customButton = new CustomButton();
        root.setCenter(customButton);
        Scene scene = new Scene(root, 400, 400);

        Duration duration = Duration.millis(800);

        TranslateTransition coinDroitSuperieur = new TranslateTransition(duration, customButton);
        coinDroitSuperieur.setByX(150);
        coinDroitSuperieur.setByY(-150);

        TranslateTransition droite = new TranslateTransition(duration, customButton);
        droite.setToX(150);

        TranslateTransition bas = new TranslateTransition(duration, customButton);
        bas.setToY(150);

        TranslateTransition gauche = new TranslateTransition(duration, customButton);
        gauche.setToX(-150);

        TranslateTransition haut = new TranslateTransition(duration, customButton);
        haut.setToY(-150);

        SequentialTransition st = new SequentialTransition(coinDroitSuperieur, bas, gauche, haut, droite);
        st.setAutoReverse(true);
        st.setCycleCount(2);
        customButton.setOnMousePressed(mouseEvent -> st.play());

        primaryStage.setTitle("Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
