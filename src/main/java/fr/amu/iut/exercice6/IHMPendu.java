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

public class IHMPendu extends Application {

    private int nbVie = 7;
    private Label nombreVie;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        // A completer

        Dico dico = new Dico();
        String motATrouver = dico.getMot();

        Pane root = new Pane();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        root.setStyle("-fx-background-color: #ccfcee");

        Image pendu7 = new Image("/exercice6/pendu7.png");
        Image pendu6 = new Image("/exercice6/pendu6.png");
        Image pendu5 = new Image("/exercice6/pendu5.png");
        Image pendu4 = new Image("/exercice6/pendu4.png");
        Image pendu3 = new Image("/exercice6/pendu3.png");
        Image pendu2 = new Image("/exercice6/pendu2.png");
        Image pendu1 = new Image("/exercice6/pendu1.png");
        Image pendu0 = new Image("/exercice6/pendu0.png");
        Image penduWin = new Image("/exercice6/penduWin.png");

        ImageView imageView = new ImageView(pendu0);
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
        for (Button bouton : boutons) {
            bouton.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
                Button source = (Button) actionEvent.getSource();
                char lettre = source.getText().charAt(0);

                if (dico.getPositions(lettre,motATrouver).isEmpty()) {
                    nbVie -= 1;
                    System.out.println(nbVie);
                    changerImage(pendu7, pendu6, pendu5, pendu4, pendu3, pendu2, pendu1, pendu0, imageView);
                    nombreVie.setText("Nombre de vie : "+nbVie);

                }

                System.out.println(dico.getPositions(lettre,motATrouver));
            });
        }

        Button rejouer = new Button("Rejouer");
        rejouer.setLayoutX(220);
        rejouer.setLayoutY(400);







        String etoileComplet = "";
        for (int compteur = 0; compteur < motATrouver.length() ; compteur++){
            etoileComplet += "*";
        }
        Label motInconnu = new Label(etoileComplet);
        motInconnu.setStyle("-fx-font-weight: bold");
        motInconnu.setLayoutY(250);
        motInconnu.setFont(new Font(20));
        motInconnu.layoutXProperty().bind(root.widthProperty().subtract(motInconnu.widthProperty()).divide(2));

        root.getChildren().addAll(imageView,nombreVie,motInconnu,grid,rejouer);


        primaryStage.show();
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

    public static void main(String[] args) {
        launch(args);
    }
}