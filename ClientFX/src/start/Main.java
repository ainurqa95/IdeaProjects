package start;

import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fmxLoader = new FXMLLoader(); // создаем объект загрузчика fxmlLoader
        fmxLoader.setLocation(getClass().getResource("../views/main.fxml")); // привязываем его к xml
        //  Parent root = FXMLLoader.load(getClass().getResource("../fxml/maket.fxml"));
        Parent root = fmxLoader.load(); // загружаем его в root
        MainController mainController = fmxLoader.getController(); // получаем контроллер нашей вьюхи xml
        mainController.setMainStage(primaryStage); // засовываем его в главную сцену этот Stage мы можем использовать в контроллере
        primaryStage.setMinHeight(300);
        primaryStage.setMinWidth(600);
        primaryStage.setTitle("Клиент");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
