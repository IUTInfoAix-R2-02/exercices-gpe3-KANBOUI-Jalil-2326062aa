package fr.amu.iut.exercice16;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConvertisseurTemperatures extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Construction

        VBox panneauCelsius = new VBox(30);
        VBox panneauFahrenheit = new VBox(30);


        Label celsiusText = new Label("°C");
        celsiusText.setStyle("-fx-font-weight: BOLD");

        Slider celsius = new Slider(0, 100, 10);
        celsius.setShowTickMarks(true);
        celsius.setShowTickLabels(true);
        celsius.setMajorTickUnit(10f);
        celsius.setBlockIncrement(1f);
        celsius.setOrientation(Orientation.VERTICAL);
        celsius.setPrefHeight(500);

        /*TextField celsiusTextField = new TextField();
        celsiusTextField.setPrefWidth(50);*/





        Label fahrenheitText = new Label("°F");
        fahrenheitText.setStyle("-fx-font-weight: BOLD");

        Slider fahrenheit = new Slider(0, 212, 10);
        fahrenheit.setShowTickMarks(true);
        fahrenheit.setShowTickLabels(true);
        fahrenheit.setMajorTickUnit(10f);
        fahrenheit.setBlockIncrement(1f);
        fahrenheit.setOrientation(Orientation.VERTICAL);
        fahrenheit.setPrefHeight(500);

        /*TextField fahrenheitTextField = new TextField();
        fahrenheitTextField.setPrefWidth(50);*/

        panneauCelsius.getChildren().addAll(celsiusText,celsius);
        panneauFahrenheit.getChildren().addAll(fahrenheitText,fahrenheit);
















        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}