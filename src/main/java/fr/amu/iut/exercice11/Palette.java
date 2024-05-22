package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;


    private IntegerProperty nbFois;
    private StringProperty message;
    private StringProperty couleurPanneau;

    public Palette() {
        nbFois = new SimpleIntegerProperty(0);
        message = new SimpleStringProperty ("");
        couleurPanneau = new SimpleStringProperty("#000000");
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label("Cliquez sur un bouton");
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");




        vert.setOnAction(actionEvent -> {
            nbVert ++;
            nbFois.setValue(nbVert);
            message.setValue("Vert");
            couleurPanneau.setValue("GREEN");
        });

        rouge.setOnAction(actionEvent -> {
            nbRouge ++;
            nbFois.setValue(nbRouge);
            message.setValue("Rouge");
            couleurPanneau.setValue("RED");
        });

        bleu.setOnAction(event -> {
            nbBleu ++;
            nbFois.setValue(nbBleu);
            message.setValue("Bleu");
            couleurPanneau.setValue("BLUE");
        });

        texteDuHaut.textProperty().bind(Bindings.when(nbFois.isNotEqualTo(0)).then(Bindings.concat(message," choisi ", nbFois, " fois")).otherwise("Cliquez sur un bouton"));
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color: ", couleurPanneau));


        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createBindings(){
        BooleanProperty pasEncoreDeClick = null;
        if (nbFois.isEqualTo(0)){
            pasEncoreDeClick.setValue(true);
        }
        else {
            pasEncoreDeClick.setValue(false);
        }
    }
}

