package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label label;
    private Pane panneau;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();


        Button vert = new Button("Vert");
        Button rouge = new Button("Rouge");
        Button bleu = new Button("Bleu");

        HBox bas = new HBox(10);
        bas.getChildren().addAll(vert, rouge, bleu);
        bas.setAlignment(Pos.CENTER);
        bas.setPadding(new Insets(10));

        panneau = new Pane();

        label = new Label();
        label.setStyle("-fx-font-weight: bold");
        label.setStyle("-fx-font-size: 20");


        vert.addEventFilter(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbVert += 1;
            label.setText("Vert choisi " + nbVert + " fois");
            panneau.setStyle("-fx-background-color : green");
        });

        rouge.addEventFilter(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbRouge += 1;
            label.setText("Rouge choisi " + nbRouge + " fois");
            panneau.setStyle("-fx-background-color : red");
        });

        bleu.addEventFilter(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbBleu += 1;
            label.setText("Bleu choisi " + nbBleu + " fois");
            panneau.setStyle("-fx-background-color : blue");
        });


        root.setTop(label);
        root.setCenter(panneau);
        root.setBottom(bas);
        BorderPane.setAlignment(label,Pos.CENTER);



        Scene scene = new Scene(root,400,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

