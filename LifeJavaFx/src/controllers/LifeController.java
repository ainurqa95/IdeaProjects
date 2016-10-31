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
import models.LifeTable;
import models.LifeTableDriver;
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

    public void setSizeWindow(double sizeXPole, double sizeYPole) { // размеры окна
        this.sizeXPole = sizeXPole; this.sizeYPole = sizeYPole;
    }



    @FXML
    AnchorPane anchorMain;


    public void setLife(MyLife life, int countLife ) { // создаем начальную популяцию
        this.life = life; this.countLife = countLife;
        life.generatePole(this.countLife);
    }

//    public void actionClose(ActionEvent actionEvent) { // при нажатии на кнопку закрыть
//        Node source =  (Node)   actionEvent.getSource();
//        Stage stage = (Stage)source.getScene().getWindow();
//        stage.hide();//  т.е это окно всегда есть в памяти мметод hide его скрывает просто
//    }
    private void showPole() throws Exception {
        double oneCircleX = this.sizeXPole/life.Get_size(); // делим размер окна на размер
        double radius = oneCircleX/2; // получаем радиус кружочка
        double x1 = radius;
        double y1 = radius;
        int size = life.Get_size();
        Circle [][] c = new Circle[size][size];  // матрица кружков
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {


                c[i][j] = new Circle();
                c[i][j].setCenterX(x1); // задаем размеры центра
                c[i][j].setCenterY(y1);
                c[i][j].setRadius(radius); // и радиус
                if ( life.Get_state(i,j)  ) // если есть жизнь в нашей популяции
                c[i][j].setFill(Color.GREEN); // отоброжаем зеленым
                 else    c[i][j].setFill(Color.GRAY); // иначе серым


                c[i][j].setOnMousePressed(new EventHandler<MouseEvent>() { // событие на нажатие на какой-нибудь кружо
                    @Override
                    public void handle(MouseEvent event) {

                        int j1=(int)(event.getSceneX()/(2*radius)); //индексы наших кружков
                        int i1=(int)((event.getSceneY()-30)/(2*radius));

                        try {
                            if(!life.Get_state(i1, j1)){ // если кружок был серым т.е жизни не было
                                life.Set_state(i1,j1, true); // говорим, что там будет жизнь
                                c[i1][j1].setFill(Color.GREEN); // говорим, что он будет зеленым

                              }else { // если жизнь была
                                life.Set_state(i1,j1, false); // то делаем ее невыносимой
                                c[i1][j1].setFill(Color.GRAY); // и убиваем жизнь

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                });

                anchorMain.getChildren().add(c[i][j]); // добавляем наш кружок в панельку
                x1 = x1 + 2 * radius; // передвигаем центр по радиусу вправо
            }
            x1 = radius;
            y1 = y1 + 2 * radius; // передвигаемся вниз

        }


    }

    public void actionGeneration(ActionEvent actionEvent) throws Exception {


        LifeTableDriver lifes = new LifeTableDriver();
       // lifes.insert(2,3,1);
        lifes.update(2,2,2,2);
        for (LifeTable life : lifes.getTableLifes()
             ) {
            System.out.println("coord_i = "+ life.getCord_i()+ "coord_j = " + life.getCord_j());

        }
     //   showPole(); // показываем поле
        //life.nextGeneration(); // следующее поколение
    }

    public void actionSave(ActionEvent actionEvent) throws Exception { // делаем слепок поля
        LifeTableDriver lifes = new LifeTableDriver();
        if(lifes.getTableLifes().size()==0) { // если ничего в бд нет
            for (int i = 0; i < this.life.Get_size(); i++) {
                for (int j = 0; j < this.life.Get_size(); j++) {
                    if (life.Get_state(i, j)) // добавляем индексы где есть жизнь
                        lifes.insert(i, j, 1);
                }
            }
        } // если есть обновляем бд
        else{
            for (int i = 0; i < this.life.Get_size(); i++) {
                for (int j = 0; j < this.life.Get_size(); j++) {
                    if (life.Get_state(i, j))//елси жизни в бд не было то мы ее добавили
                        lifes.insert(i, j, 1);
                    else { // там где жизни в нашем экземпляре нет, мы должны удалить из бд
                            lifes.delete(i,j);
                    }
                }
            }


        }

    }
}
