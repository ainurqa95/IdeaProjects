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
        double radius = oneCircleX/2;
        double x1 = radius;
        double y1 = radius + 20;
        for (int i = 0; i <life.Get_size() ; i++) {
            Circle c = new Circle();
            c.setCenterX(x1);
            c.setCenterY(y1);
            c.setRadius(radius);
            c.setFill(Color.AQUA);
            anchorMain.getChildren().add(c);
            x1 = x1 + 2*radius;

        }


    }

    public void actionGeneration(ActionEvent actionEvent) {
        showPole();
    }
}
