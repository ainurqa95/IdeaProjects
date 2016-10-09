package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent panel = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        Button button = new Button("text");
//        Text text = new Text(50,40, "javafx");// label
//        text.setFont(new Font(40));// шрифт
//        BorderPane pane = new BorderPane();
//        pane.setCenter(button);
//        pane.setTop(text);
        Scene scene = new Scene(panel,800,400);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
