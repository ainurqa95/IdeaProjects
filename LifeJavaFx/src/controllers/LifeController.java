package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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

    public void setLife(MyLife life, int countLife ) {
        this.life = life; this.countLife = countLife;
        life.generatePole(this.countLife);
    }
    @FXML
    private void initialize(){ // инициализируем начальную взаимосвязь xml с
    //    Circle c = new Circle();
      //  c.setCenterX(50);
      //  c.setCenterY(50);
      //  c.setRadius(50);
       // c.setFill(Color.AQUA);
        //anchorMain.getChildren().add(c);
    //    showPole();


    }
//    public void actionClose(ActionEvent actionEvent) { // при нажатии на кнопку закрыть
//        Node source =  (Node)   actionEvent.getSource();
//        Stage stage = (Stage)source.getScene().getWindow();
//        stage.hide();//  т.е это окно всегда есть в памяти мметод hide его скрывает просто
//    }
    private void showPole(){
        double oneCircleX = this.sizeXPole/life.Get_size();
        double radius = oneCircleX/4;
        double x1 = radius;
        double y1 = radius + 20;
        int size = life.Get_size();
        Circle [][] c = new Circle[size][size];
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {


                c[i][j] = new Circle();
                c[i][j].setCenterX(x1);
                c[i][j].setCenterY(y1);
                c[i][j].setRadius(radius);
                c[i][j].setFill(Color.AQUA);
                anchorMain.getChildren().add(c[i][j]);
                x1 = x1 + 2 * radius;
            }
            x1 = radius;
            y1 = y1 + 2 * radius;

        }


    }

    public void actionGeneration(ActionEvent actionEvent) {
        showPole();
    }
}
