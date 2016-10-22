package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import models.MyLife;

import java.io.IOException;

/**
 * Created by ainur on 16.10.16.
 */
public class LifeController {
    private MyLife life;
    private int countLife;
    private double sizeXPole;
    private double sizeYPole;

    public void setSizeWindow(double sizeXPole, double sizeYPole) {
        this.sizeXPole = sizeXPole; this.sizeYPole = sizeYPole;
    }



    @FXML
    AnchorPane anchorMain;

    @FXML
    Label labelCoords;

    public void setLife(MyLife life, int countLife ) {
        this.life = life; this.countLife = countLife;
        life.generatePole(this.countLife);
    }

//    public void actionClose(ActionEvent actionEvent) { // при нажатии на кнопку закрыть
//        Node source =  (Node)   actionEvent.getSource();
//        Stage stage = (Stage)source.getScene().getWindow();
//        stage.hide();//  т.е это окно всегда есть в памяти мметод hide его скрывает просто
//    }
    private void showPole() throws Exception {
        double oneCircleX = this.sizeXPole/life.Get_size();
        double radius = oneCircleX/2;
        double x1 = radius;
        double y1 = radius; //+ 20;
        int size = life.Get_size();
        Circle [][] c = new Circle[size][size];
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {


                c[i][j] = new Circle();
                c[i][j].setCenterX(x1);
                c[i][j].setCenterY(y1);


                c[i][j].setRadius(radius);
                if ( life.Get_state(i,j)  )
                c[i][j].setFill(Color.GREEN);
                 else    c[i][j].setFill(Color.GRAY);


                c[i][j].setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {

                        int j1=(int)(event.getSceneX()/(2*radius)); //индексы наших кружков
                        int i1=(int)((event.getSceneY()-30)/(2*radius));

                        try {
                            if(!life.Get_state(i1, j1)){
                                life.Set_state(i1,j1, true);
                                c[i1][j1].setFill(Color.GREEN);

                              }else {
                                life.Set_state(i1,j1, false);
                                c[i1][j1].setFill(Color.GRAY);

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        String coords = String.valueOf(i1);
                        coords += " " + String.valueOf(j1);
                        labelCoords.setText(coords);

                    }
                });

                anchorMain.getChildren().add(c[i][j]);
                x1 = x1 + 2 * radius;
            }
            x1 = radius;
            y1 = y1 + 2 * radius;

        }


    }

    public void actionGeneration(ActionEvent actionEvent) throws Exception {
        showPole();
        life.nextGeneration();
    }
}
