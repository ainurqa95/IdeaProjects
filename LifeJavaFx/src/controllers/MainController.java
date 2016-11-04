package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.MyLife;

import java.io.IOException;

public class MainController {
    private Stage mainStage;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    } // setter Stage

    @FXML// объявляем переменные  соответствующие fx id в fxml
    TextField txtCountLife;

    @FXML
    TextField txtRows;
    @FXML
    TextField txtColumns;
    @FXML
    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private LifeController lifeController;
    private Stage poleStage;
    private double sizeXPole = 600; // размеры поля
    private double sizeYPole = 600;
    @FXML
    private void initialize(){ // инициализируем начальную взаимосвязь xml и

        try{

            fxmlLoader.setLocation(getClass().getResource("../views/pole.fxml")); //
            fxmlEdit  = fxmlLoader.load();                // нашему root присваиваем ресурс xml edit
            lifeController = fxmlLoader.getController();            // с помощью ссылки на этот контроллер можем манипулировать данными

        }
        catch (IOException e){
            e.printStackTrace();
        }


    }


    public void actionButtonGo(ActionEvent actionEvent) throws Exception {

        int n = Integer.parseInt(txtRows.getText()); // берем размеры из формы
        int m = Integer.parseInt(txtColumns.getText());
        int countLife = Integer.parseInt(txtCountLife.getText());
        MyLife life = new MyLife(n,m);
        this.lifeController.setLife(life, countLife); // создаем начальную популяцию
        this.lifeController.setSizeWindow(sizeXPole,sizeYPole); // задаем размеры сцены в контроллер

        if( this.poleStage==null){ //
            this.poleStage = new Stage();
            this.poleStage.setTitle("Поле");
            this.poleStage.setMinHeight(sizeXPole+30);
            this.poleStage.setMinWidth(sizeYPole);
            this.poleStage.setResizable(true);
            this.poleStage.setScene(new Scene(fxmlEdit));// берем из fxml
            //      poleStage.initModality(Modality.WINDOW_MODAL); // говорим что окно модальное
            // poleStage.initOwner(mainStage);// достаем информацию о родитеь=льском окне

        }
        this.lifeController.showPole(); // показываем начальную популяцию
        this.poleStage.showAndWait(); // ожидать закрытие окна


    }
}
