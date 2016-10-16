package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage mainStage;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    } // setter Stage

    @FXML
    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private LifeController lifeController;
    private Stage poleStage;
    @FXML
    private void initialize(){ // инициализируем начальную взаимосвязь xml с

        try{
            fxmlLoader.setLocation(getClass().getResource("../views/pole.fxml"));
            fxmlEdit  = fxmlLoader.load();                // нашему root присваиваем ресурс xml edit
            lifeController = fxmlLoader.getController();            // с помощью ссылки на этот контроллер можем манипулировать данными

        }
        catch (IOException e){
            e.printStackTrace();
        }


    }


    public void actionButtonGo(ActionEvent actionEvent) {

        if(poleStage==null){ // инициализируем диалог
            poleStage = new Stage();
            poleStage.setTitle("Поле");
            poleStage.setMinHeight(300);
            poleStage.setMinWidth(300);
            poleStage.setResizable(false);
            poleStage.setScene(new Scene(fxmlEdit));// берем из fxml
            //      poleStage.initModality(Modality.WINDOW_MODAL); // говорим что окно модальное
            // poleStage.initOwner(mainStage);// достаем информацию о родитеь=льском окне

        }
        //poleStage.show();
        poleStage.showAndWait(); // ожидать закрытие окна

    }
}
