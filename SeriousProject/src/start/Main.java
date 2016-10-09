package start;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.AddressBookCollection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("../fxml/maket.fxml"));
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
