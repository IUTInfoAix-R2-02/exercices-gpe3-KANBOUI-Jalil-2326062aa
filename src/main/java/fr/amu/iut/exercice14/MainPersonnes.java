package fr.amu.iut.exercice14;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("Duplicates")
public class MainPersonnes {

    private static ObservableList<Personne> lesPersonnes;
    private static IntegerProperty ageMoyen;
    private static IntegerProperty nbParisiens;

    private static IntegerBinding calculAgeMoyen;
    private static IntegerBinding calculnbParisiens;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList(personne -> new Observable[]{personne.ageProperty(),personne.villeDeNaissanceProperty()});
        ageMoyen = new SimpleIntegerProperty(0);
        nbParisiens = new SimpleIntegerProperty(0);

        calculerAgeMoyen();
        calculerNbParisiens();

        question1();
        question2();
    }


    private static void calculerAgeMoyen() {
        calculAgeMoyen = Bindings.createIntegerBinding(() -> {
            int sum = 0;
            if (!lesPersonnes.isEmpty()){
                for (Personne personne : lesPersonnes) {
                    sum += personne.getAge();
                }
                return sum / lesPersonnes.size();
            }
            else {
                return 0;
            }
        }, lesPersonnes);


        calculAgeMoyen.addListener((observable, oldValue, newValue) -> {
            ageMoyen.set(newValue.intValue());
        });

        ageMoyen.set(calculAgeMoyen.get());
    }

    private static void calculerNbParisiens() {
        calculnbParisiens = Bindings.createIntegerBinding(() -> {
            int compteur = 0;
            if (!lesPersonnes.isEmpty()){
                for (Personne personne : lesPersonnes){
                    if ("Paris".equals(personne.getVilleDeNaissance())) {
                        compteur += 1;
                    }
                }
                return compteur;
            }
            else {
                return 0;
            }
        }, lesPersonnes);

        calculnbParisiens.addListener((observable, oldValue, newValue) -> {
            nbParisiens.set(newValue.intValue());
        });

        nbParisiens.setValue(calculnbParisiens.getValue());
    }



    public static void question1() {
        System.out.println("1 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        Personne pierre = new Personne("Pierre", 20);
        lesPersonnes.add(pierre);
        System.out.println("2 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        Personne paul = new Personne("Paul", 40);
        lesPersonnes.add(paul);
        System.out.println("3 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(jacques);
        System.out.println("4 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        paul.setAge(100);
        System.out.println("5 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        lesPersonnes.remove(paul);
        System.out.println("6 - L'age moyen est de " + ageMoyen.getValue() + " ans");
    }

    public static void question2() {
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
        lesPersonnes.get(0).setVilleDeNaissance("Marseille");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
        lesPersonnes.get(1).setVilleDeNaissance("Montpellier");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisien");
        for (Personne p : lesPersonnes)
            p.setVilleDeNaissance("Paris");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
    }

}

