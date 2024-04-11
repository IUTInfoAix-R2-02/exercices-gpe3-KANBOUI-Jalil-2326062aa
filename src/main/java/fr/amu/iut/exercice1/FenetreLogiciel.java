package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // code de l'exercice 1

        // Pour le Haut
        MenuBar top = new MenuBar();

        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");


        SeparatorMenuItem s1 = new SeparatorMenuItem();
        SeparatorMenuItem s2 = new SeparatorMenuItem();
        SeparatorMenuItem s3 = new SeparatorMenuItem();
        SeparatorMenuItem s4 = new SeparatorMenuItem();
        SeparatorMenuItem s5 = new SeparatorMenuItem();


        MenuItem New = new MenuItem("New");
        MenuItem Open = new MenuItem("Open");
        MenuItem Save = new MenuItem("Save");
        MenuItem Close = new MenuItem("Close");

        MenuItem Cut = new MenuItem("Cut");
        MenuItem Copy = new MenuItem("Copy");
        MenuItem Paste = new MenuItem("Paste");


        file.getItems().addAll(New,s1,Open,s2,Save,s3,Close);
        edit.getItems().addAll(Cut,s4,Copy,s5,Paste);


        top.getMenus().addAll(file,edit,help);



        // Pour la gauche

        Button b1 = new Button("Bouton 1");
        Button b2 = new Button("Bouton 2");
        Button b3 = new Button("Bouton 3");

        VBox boiteABouttons = new VBox();
        Label texteBoiteButtons = new Label("Bouttons :");
        boiteABouttons.setAlignment(Pos.CENTER);
        boiteABouttons.getChildren().addAll(texteBoiteButtons,b1,b2,b3);

        boiteABouttons.setSpacing(10);

//        VBox.setMargin(boiteABouttons, new Insets(0,0,10,0));
//        boiteABouttons.setMargin(b1, new Insets(0,0,10,0));
//        boiteABouttons.setMargin(b2, new Insets(0,0,10,0));

        HBox boiteABoutonsSep = new HBox();
        Separator separ1 = new Separator(Orientation.VERTICAL);
        boiteABoutonsSep.getChildren().addAll(boiteABouttons,separ1);


        //Pour la bas



        HBox bot = new HBox();
        Label texteBot = new Label("Ceci est un label de bas de page");
        bot.setAlignment(Pos.BOTTOM_CENTER);
        bot.getChildren().addAll(texteBot);
        Separator separ2 = new Separator(Orientation.HORIZONTAL);
        VBox botSep = new VBox();
        botSep.getChildren().addAll(separ2,bot);




        //Pour la gauche


        Label name = new Label("Name:");
        Label email = new Label("Email:");
        Label password = new Label("Password:");
        TextField pourName = new TextField();
        TextField pourEmail = new TextField();
        TextField pourPassword = new TextField();


        GridPane formulaireG = new GridPane();
        GridPane.setConstraints(name, 0, 1);
        GridPane.setConstraints(email, 0, 2);
        GridPane.setConstraints(password, 0, 3);
        GridPane.setConstraints(pourName, 1, 1);
        GridPane.setConstraints(pourEmail, 1, 2);
        GridPane.setConstraints(pourPassword, 1, 3);





        formulaireG.getChildren().addAll(name,email,password,pourName,pourEmail,pourPassword);
        formulaireG.setVgap(10);
        formulaireG.setHgap(10);
        formulaireG.setPadding(new Insets(10,10,10,10));
//        formulaireG.setMargin(pourName, new Insets(0,0,10,10));
//        formulaireG.setMargin(pourEmail, new Insets(0,0,10,10));
//        formulaireG.setMargin(pourPassword, new Insets(0,0,10,10));


        formulaireG.setAlignment(Pos.CENTER);

        VBox formulaire = new VBox();
        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");
        HBox boutons = new HBox();
        boutons.getChildren().addAll(submit,cancel);
        boutons.setSpacing(10);
//        boutons.setMargin(submit, new Insets(0,10,0,0));
//        boutons.setMargin(cancel, new Insets(0,10,0,0));
        boutons.setAlignment(Pos.CENTER);

        formulaire.getChildren().addAll(formulaireG,boutons);
        formulaire.setAlignment(Pos.CENTER);





        //Pour la fin


        BorderPane boitefin = new BorderPane();
        boitefin.setTop(top);
        boitefin.setBottom(botSep);
        boitefin.setLeft(boiteABoutonsSep);
        boitefin.setCenter(formulaire);
        Scene fin = new Scene(boitefin, 600, 600);


        primaryStage.setScene(fin);
        primaryStage.show();




    }

    public static void main(String[] args) {
        launch(args);

    }
}

