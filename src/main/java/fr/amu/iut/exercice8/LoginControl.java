package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    private Button ok;
    @FXML
    private Button cancel;
    @FXML
    private TextField identifiant;
    @FXML
    private PasswordField pwd;

    @FXML
    private void okClicked() {
        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            String identifiantText = identifiant.getText();
            String pwdText = pwd.getText();
            StringBuilder pwdEtoileText = new StringBuilder();
            for (int compteur = 0; compteur < pwdText.length(); compteur++) {
                pwdEtoileText.append("*");
            }

            // Affichage dans la console
            System.out.println("Identifiant: " + identifiantText);
            System.out.println("Mot de passe (étoiles): " + pwdEtoileText.toString());
        });
    }


@FXML
    private void cancelClicked() {
        cancel.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            identifiant.clear();
            pwd.clear();
        });
    }

}