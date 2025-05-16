package com.example.exercice12;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class CustomButton extends Button {
    private final IntegerProperty nbClics = new SimpleIntegerProperty(0);
    private final Color couleur;

    public CustomButton(String text, Color couleur) {
        super(text);
        this.couleur = couleur;
    }

    public int getNbClics() {
        return nbClics.get();
    }

    public void setNbClics(int value) {
        nbClics.set(value);
    }

    public IntegerProperty nbClicsProperty() {
        return nbClics;
    }

    public Color getCouleur() {
        return couleur;
    }
}
