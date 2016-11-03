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
import java.util.Iterator;

/**
 * Created by ainur on 16.10.16.
 */
public class LifeController {
    private MyLife life;
    private int countLife;
    private double sizeXPole;
    private double sizeYPole;

    private LifeTableDriver lifesInTable;

    public void setSizeWindow(double sizeXPole, double sizeYPole) { // размеры окна
        this.sizeXPole = sizeXPole; this.sizeYPole = sizeYPole;
    }



    @FXML
    AnchorPane anchorMain;


    public void setLife(MyLife life, int countLife ) throws Exception { // создаем начальную популяцию
        this.life = life; this.countLife = countLife;
        life.generatePole(this.countLife);
         // показываем поле
    }

//    public void actionClose(ActionEvent actionEvent) { // при нажатии на кнопку закрыть
//        Node source =  (Node)   actionEvent.getSource();
//        Stage stage = (Stage)source.getScene().getWindow();
//        stage.hide();//  т.е это окно всегда есть в памяти мметод hide его скрывает просто
//    }
    public void showPole() throws Exception {
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


        life.nextGeneration(); // следующее поколение
        showPole(); // показываем поле
    }

    public void actionSave(ActionEvent actionEvent) throws Exception { // делаем слепок поля
        this.lifesInTable = new LifeTableDriver();
        if(this.lifesInTable.getTableLifes().size()==0) { // если ничего в бд нет
            insertLifesToDB();
        } // если есть обновляем бд
        else { // если есть удаляем все
//            for (LifeTable item : this.lifesInTable.getTableLifes()
//                    ) {
//                this.lifesInTable.delete(item.getCord_i(), item.getCord_j(), 1);
//            }
            Iterator<LifeTable> iter = this.lifesInTable.getTableLifes().iterator();
            while (iter.hasNext()) { // удаляем элемент из списка
                LifeTable item = iter.next();

              //  if (item.getCord_j() == i && item.getCord_j()==j && item.getGeneration() == generation) {
                     this.lifesInTable.delete(item.getCord_i(), item.getCord_j(), 1);
                    iter.remove();

                }

            insertLifesToDB(); // снова вставляем
        }
    }
    private void insertLifesToDB() throws Exception {

            for (int i = 0; i < this.life.Get_size(); i++) {
                for (int j = 0; j < this.life.Get_size(); j++) {
                    if (this.life.Get_state(i, j)) // добавляем индексы где есть жизнь
                        this.lifesInTable.insert(i, j, 1);
                }
            }
    }

    public void actionLoad(ActionEvent actionEvent) throws Exception {


        LifeTableDriver lifes = new LifeTableDriver();
        this.life.clear();
        for (LifeTable item : lifes.getTableLifes()
             ) {
            this.life.Set_state(item.getCord_i(), item.getCord_j(), true);
        }
        showPole();
    }
}
