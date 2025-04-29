package fr.amu.iut.exercice5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Fantome extends Personnage {

    private Rectangle basCorps;

    private Circle oeilGauche;
    private Circle retineGauche;

    private Circle oeilDroit;
    private Circle retineDroite;

    public Fantome() {
        super("droite", Color.BLUE, Color.BLUE);
        basCorps = new Rectangle(0, 10, 20, 10);
        basCorps.setFill(Color.BLUE);

        oeilGauche = new Circle(6, 6, 2, Color.WHITE);
        retineGauche = new Circle(7, 6, 1, Color.BLACK); // regarde droite

        oeilDroit = new Circle(14, 6, 2, Color.WHITE);
        retineDroite = new Circle(15, 6, 1, Color.BLACK); // regarde droite

        super.getChildren().addAll(basCorps, oeilGauche, retineGauche, oeilDroit, retineDroite);
    }

    @Override
    public void deplacerAGauche() {
        super.deplacerAGauche();
        // les rétines regardent à gauche
        retineGauche.setCenterX(oeilGauche.getCenterX() - 1);
        retineGauche.setCenterY(oeilGauche.getCenterY());

        retineDroite.setCenterX(oeilDroit.getCenterX() - 1);
        retineDroite.setCenterY(oeilDroit.getCenterY());
    }

    @Override
    public void deplacerADroite(double largeurJeu) {
        super.deplacerADroite(largeurJeu);
        // les rétines regardent à droite
        retineGauche.setCenterX(oeilGauche.getCenterX() + 1);
        retineGauche.setCenterY(oeilGauche.getCenterY());

        retineDroite.setCenterX(oeilDroit.getCenterX() + 1);
        retineDroite.setCenterY(oeilDroit.getCenterY());
    }

    @Override
    public void deplacerEnBas(double hauteurJeu) {
        super.deplacerEnBas(hauteurJeu);
        // les rétines regardent en bas
        retineGauche.setCenterX(oeilGauche.getCenterX());
        retineGauche.setCenterY(oeilGauche.getCenterY() + 1);

        retineDroite.setCenterX(oeilDroit.getCenterX());
        retineDroite.setCenterY(oeilDroit.getCenterY() + 1);
    }

    @Override
    public void deplacerEnHaut() {
        super.deplacerEnHaut();
        // les rétines regardent en haut
        retineGauche.setCenterX(oeilGauche.getCenterX());
        retineGauche.setCenterY(oeilGauche.getCenterY() - 1);

        retineDroite.setCenterX(oeilDroit.getCenterX());
        retineDroite.setCenterY(oeilDroit.getCenterY() - 1);
    }
}
