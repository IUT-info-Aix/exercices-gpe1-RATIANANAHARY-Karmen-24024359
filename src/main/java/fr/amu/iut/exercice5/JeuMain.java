package fr.amu.iut.exercice5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class JeuMain extends Application {

    private static final ArrayList<Obstacle> obstacles = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        double largeurScene = 600;
        double hauteurScene = 400;

        Pacman pacman = new Pacman();
        Fantome fantome = new Fantome();

        pacman.setLayoutX(50);
        pacman.setLayoutY(hauteurScene / 2);
        fantome.setLayoutX(largeurScene - 100);
        fantome.setLayoutY(hauteurScene / 2);
        Obstacle mur = new Obstacle(250, 100, 100, 200);
        obstacles.add(mur);

        root.getChildren().addAll(pacman, fantome, mur);
        Scene scene = new Scene(root, largeurScene, hauteurScene);

        Timeline timer = new Timeline(new KeyFrame(Duration.seconds(20), e -> {
            System.out.println("Temps écoulé ! Le fantôme a gagné !");
            scene.setOnKeyPressed(null); // Bloquer les mouvements
        }));
        timer.setCycleCount(1);
        timer.play();

        scene.setOnKeyPressed(event -> {
            double oldX, oldY;

            // Pacman
            if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN ||
                    event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.RIGHT) {

                oldX = pacman.getLayoutX();
                oldY = pacman.getLayoutY();

                switch (event.getCode()) {
                    case UP -> pacman.deplacerEnHaut();
                    case DOWN -> pacman.deplacerEnBas(hauteurScene);
                    case LEFT -> pacman.deplacerAGauche();
                    case RIGHT -> pacman.deplacerADroite(largeurScene);
                }

                if (collisionAvecObstacle(pacman)) {
                    pacman.setLayoutX(oldX);
                    pacman.setLayoutY(oldY);
                }
            }

            // Fantôme
            if (event.getCode() == KeyCode.Z || event.getCode() == KeyCode.S ||
                    event.getCode() == KeyCode.Q || event.getCode() == KeyCode.D) {

                oldX = fantome.getLayoutX();
                oldY = fantome.getLayoutY();

                switch (event.getCode()) {
                    case Z -> fantome.deplacerEnHaut();
                    case S -> fantome.deplacerEnBas(hauteurScene);
                    case Q -> fantome.deplacerAGauche();
                    case D -> fantome.deplacerADroite(largeurScene);
                }

                if (collisionAvecObstacle(fantome)) {
                    fantome.setLayoutX(oldX);
                    fantome.setLayoutY(oldY);
                }
            }

            if (pacman.getBoundsInParent().intersects(fantome.getBoundsInParent())) {
                System.out.println("Pacman a attrapé le fantôme !");
                timer.stop();
                scene.setOnKeyPressed(null); // Fin du jeu
            }
        });

        primaryStage.setTitle("Pacman vs Fantôme");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean collisionAvecObstacle(Personnage perso) {
        for (Obstacle obs : obstacles) {
            if (perso.getBoundsInParent().intersects(obs.getBoundsInParent())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
