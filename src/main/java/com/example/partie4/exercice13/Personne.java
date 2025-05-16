package com.example.partie4.exercice13;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Personne {

    private final StringProperty nom = new SimpleStringProperty();
    private final IntegerProperty age = new SimpleIntegerProperty();

    public Personne(String nom, int age) {
        this.nom.set(nom);
        this.age.set(age);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    @Override
    public String toString() {
        return getNom() + " (" + getAge() + " ans)";
    }
}
