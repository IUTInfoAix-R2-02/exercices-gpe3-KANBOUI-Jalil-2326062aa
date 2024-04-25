package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class IHMPendu extends Application {

    private int nbVie = 7;
    private Label nombreVie;
    private String etoileComplet;
    private Label motInconnu;
    private Dico dico = new Dico();
    private String motATrouver;
    private ImageView imageView;



    private Image pendu7 = new Image("/exercice6/pendu7.png");
    private Image pendu6 = new Image("/exercice6/pendu6.png");
    private Image pendu5 = new Image("/exercice6/pendu5.png");
    private Image pendu4 = new Image("/exercice6/pendu4.png");
    private Image pendu3 = new Image("/exercice6/pendu3.png");
    private Image pendu2 = new Image("/exercice6/pendu2.png");
    private Image pendu1 = new Image("/exercice6/pendu1.png");
    private Image pendu0 = new Image("/exercice6/pendu0.png");
    private Image penduWin = new Image("/exercice6/penduWin.png");

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        // A completer

        nouveauMotEtEtoile();

        Pane root = new Pane();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        root.setStyle("-fx-background-color: #ccfcee");



        imageView = new ImageView(pendu0);
        imageView.setLayoutX(160);
        imageView.setLayoutY(50);


        imageView.setImage(pendu7);

        changerImage(pendu7, pendu6, pendu5, pendu4, pendu3, pendu2, pendu1, pendu0, imageView);


        GridPane grid = new GridPane();
        Button a = new Button("a");
        Button e = new Button("e");
        Button i = new Button("i");
        Button o = new Button("o");
        Button u = new Button("u");
        Button y = new Button("y");
        Button b = new Button("b");
        Button c = new Button("c");
        Button d = new Button("d");
        Button f = new Button("f");
        Button g = new Button("g");
        Button h = new Button("h");
        Button j = new Button("j");
        Button k = new Button("k");
        Button l = new Button("l");
        Button m = new Button("m");
        Button n = new Button("n");
        Button p = new Button("p");
        Button q = new Button("q");
        Button r = new Button("r");
        Button s = new Button("s");
        Button t = new Button("t");
        Button v = new Button("v");
        Button w = new Button("w");
        Button x = new Button("x");
        Button z = new Button("z");

        grid.add(a,2,1);
        grid.add(e,3,1);
        grid.add(i,4,1);
        grid.add(o,5,1);
        grid.add(u,6,1);
        grid.add(y,7,1);
        grid.addRow(2,b,c,d,f,g,h,j,k,l,m);
        grid.addRow(3,n,p,q,r,s,t,v,w,x,z);

        grid.setLayoutY(300);
        grid.layoutXProperty().bind(root.widthProperty().subtract(grid.widthProperty()).divide(2));

        nombreVie = new Label("Nombre de vie : "+nbVie);
        nombreVie.setStyle("-fx-font-weight: bold");
        nombreVie.setLayoutX(185);
        nombreVie.setLayoutY(220);

        Button[] boutons = {a, e, i, o, u, y, b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, z};

        for (int compteur = 0 ; compteur < boutons.length ; compteur ++){
            styleButton(boutons[compteur]);
        }


        for (Button bouton : boutons) {
            bouton.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
                Button source = (Button) actionEvent.getSource();
                char lettre = source.getText().charAt(0);
                char[] temp = etoileComplet.toCharArray();

                if (dico.getPositions(lettre,motATrouver).isEmpty()) {
                    nbVie -= 1;
                    changerImage(pendu7, pendu6, pendu5, pendu4, pendu3, pendu2, pendu1, pendu0, imageView);
                    nombreVie.setText("Nombre de vie : "+nbVie);

                }
                else {
                    ArrayList<Integer> positions = dico.getPositions(lettre,motATrouver);
                    for( int compteur = 0 ; compteur < positions.size() ; compteur ++){
                        if (temp[positions.get(compteur)] == lettre){
                            break;
                        }
                        else {
                            temp [positions.get(compteur)] = lettre;
                        }
                    }
                    etoileComplet = new String(temp);
                    motInconnu.setText(etoileComplet);
                }
                if (motATrouver.equals(etoileComplet) && nbVie > 0 ){
                    imageView.setImage(penduWin);
                }
            });
        }

        Button rejouer = new Button("Rejouer");
        rejouer.setLayoutX(180);
        rejouer.setLayoutY(450);
        rejouer.setStyle("-fx-font-weight: bold; -fx-background-color:rgb(202,250,237); -fx-text-fill: #e8c1a0; -fx-font-size: 16px; -fx-border-color: #79d5cc; -fx-border-radius: 50; -fx-border-width: 2; -fx-min-height: 45; -fx-min-width: 120; -fx-max-height: 45;-fx-max-width: 120");

        rejouer.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
                relancer();
        });







        motInconnu = new Label(etoileComplet);
        motInconnu.setStyle("-fx-font-weight: bold");
        motInconnu.setLayoutY(250);
        motInconnu.setFont(new Font(20));
        motInconnu.layoutXProperty().bind(root.widthProperty().subtract(motInconnu.widthProperty()).divide(2));

        root.getChildren().addAll(imageView,nombreVie,motInconnu,grid,rejouer);


        primaryStage.show();
    }

    private void relancer() {
        nouveauMotEtEtoile();
        motInconnu.setText(etoileComplet);
        nbVie = 7;
        nombreVie.setText("Nombre de vie : "+nbVie);
        changerImage(pendu7, pendu6, pendu5, pendu4, pendu3, pendu2, pendu1, pendu0, imageView);
    }

    private void nouveauMotEtEtoile() {
        motATrouver = dico.getMot();
        etoileComplet = "";
        for (int compteur = 0; compteur < motATrouver.length() ; compteur++){
            etoileComplet += "*";
        }
    }

    private void changerImage(Image pendu7, Image pendu6, Image pendu5, Image pendu4, Image pendu3, Image pendu2, Image pendu1, Image pendu0, ImageView imageView) {
        switch (nbVie) {
            case 0:
                imageView.setImage(pendu0);
                break;
            case 1:
                imageView.setImage(pendu1);
                break;
            case 2:
                imageView.setImage(pendu2);
                break;
            case 3:
                imageView.setImage(pendu3);
                break;
            case 4:
                imageView.setImage(pendu4);
                break;
            case 5:
                imageView.setImage(pendu5);
                break;
            case 6:
                imageView.setImage(pendu6);
                break;
            case 7:
                imageView.setImage(pendu7);
                break;
        }
    }





    public void styleButton(Button b1) {
        b1.setStyle("-fx-font-weight: bold; -fx-background-color:rgb(202,250,237); -fx-text-fill: #79d5cc; -fx-font-size: 16px; -fx-border-color: #e8c1a0; -fx-border-radius: 5; -fx-border-width: 2; -fx-min-height: 45; -fx-min-width: 45; -fx-max-height: 45;-fx-max-width: 45");

    }

    public static void main(String[] args) {
        launch(args);
    }
}