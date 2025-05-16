package com.example.partie4.exercice13;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class MainPersonnes {

    public static void main(String[] args) {

        // Étape finale (quand on veut écouter les changements d'attributs internes comme age) :
        ObservableList<Personne> lesPersonnes = FXCollections.observableArrayList(
                personne -> new javafx.beans.Observable[]{personne.ageProperty()}
        );

        // Étape 1 & 2 : Listener basique (ajout/suppression)
        ListChangeListener<Personne> unChangementListener = change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (Personne p : change.getAddedSubList()) {
                        System.out.println(p.getNom() + " a été ajouté.");
                    }
                }
                if (change.wasRemoved()) {
                    for (Personne p : change.getRemoved()) {
                        System.out.println(p.getNom() + " a été supprimé.");
                    }
                }
            }
        };

        lesPersonnes.addListener(unChangementListener);

        // Test de la question 1
        question1(lesPersonnes);
        question2(lesPersonnes);
        question3(lesPersonnes);
    }

    public static void question1(ObservableList<Personne> lesPersonnes) {
        lesPersonnes.add(new Personne("Pierre", 25));
    }

    public static void question2(ObservableList<Personne> lesPersonnes) {
        lesPersonnes.add(new Personne("Luc", 30));
        lesPersonnes.remove(0); // Supprimer le premier
    }

    public static void question3(ObservableList<Personne> lesPersonnes) {
        Personne p = new Personne("Pierre", 25);
        lesPersonnes.add(p);
        p.setAge(26);
    }

    public static void question5(ObservableList<Personne> lesPersonnes) {
        lesPersonnes.clear();
        Personne p1 = new Personne("Alice", 22);
        Personne p2 = new Personne("Bob", 28);
        Personne p3 = new Personne("Chloé", 31);

        lesPersonnes.addAll(p1, p2, p3);
        lesPersonnes.remove(p2);
        p3.setAge(32);
    }
}
