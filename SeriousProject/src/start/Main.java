package start;


import controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.AddressBookCollection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

            FXMLLoader fmxLoader = new FXMLLoader(); // создаем объект загрузчика fxmlLoader
            fmxLoader.setLocation(getClass().getResource("../fxml/maket.fxml")); // привязываем его к xml
          //  Parent root = FXMLLoader.load(getClass().getResource("../fxml/maket.fxml"));
            Parent root = fmxLoader.load(); // загружаем его в root
            MainController mainController = fmxLoader.getController(); // получаем контроллер нашей вьюхи xml
            mainController.setMainStage(primaryStage); // засовываем его в главную сцену этот Stage мы можем использовать в контроллере
            primaryStage.setMinHeight(600);
            primaryStage.setMinWidth(300);
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
          //   showAdressBooksItems();

    }
    public static void showAdressBooksItems()
    {
        AddressBookCollection mybook = new AddressBookCollection();
        mybook.addTestValues();
        mybook.print();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
