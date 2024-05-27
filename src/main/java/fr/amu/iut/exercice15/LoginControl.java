package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import java.io.IOException;
import java.net.URL;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;
    @FXML
    private Button okBtn;
    @FXML
    private Button cancelBtn;

    @FXML
    public void initialize() {
        createBindings();
    }

    private void createBindings() {
        // 1. Le champ du mot de passe n'est pas éditable si le nom de l'utilisateur fait moins de 6 caractères
        pwd.disableProperty().bind(userId.textProperty().length().lessThan(6));

        // 2. Le bouton cancel n'est pas cliquable si les deux champs sont vides
        cancelBtn.disableProperty().bind(userId.textProperty().isEmpty().and(pwd.textProperty().isEmpty()));

        // 3. Le bouton ok n'est pas cliquable tant que le mot de passe n'a pas au moins 8 caractères
        // et ne contient pas au moins une majuscule et un chiffre.
        okBtn.disableProperty().bind(
                pwd.textProperty().length().lessThan(8)
                        .or(Bindings.createBooleanBinding(() -> {
                            boolean contientMaj = false;
                            boolean contientChiffre = false;
                            for (char c : pwd.getText().toCharArray()) {
                                if (Character.isUpperCase(c)) {
                                    contientMaj = true;
                                } else if (Character.isDigit(c)) {
                                    contientChiffre = true;
                                }
                                if (contientMaj && contientChiffre) {
                                    return false;
                                }
                            }
                            return true;
                        }, pwd.textProperty()))
        );
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }







}


