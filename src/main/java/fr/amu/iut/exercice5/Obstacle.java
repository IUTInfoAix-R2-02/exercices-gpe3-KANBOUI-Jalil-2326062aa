package fr.amu.iut.exercice5;

import javafx.scene.shape.Rectangle;

public class Obstacle extends Rectangle {

    public Obstacle(double v, double v1, double v2, double v3) {
        super(v, v1, v2, v3);
    }

    boolean estEnCollision(Personnage autrePersonnage) {
        return getBoundsInParent().contains(autrePersonnage.getBoundsInParent())
                || autrePersonnage.getBoundsInParent().contains(getBoundsInParent());
    }

}
