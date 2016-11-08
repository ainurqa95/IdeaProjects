package sample;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetImpl;
import com.mysql.jdbc.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.models.News;
import sample.models.NewsDriver;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
      /*  try {
           // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/news", "root", "root");
            Statement command = (Statement) con.createStatement();
            ResultSet res = command.executeQuery("select * from news");
            while (res.next()) {
                System.out.println("" + res.getString("title"));

            }

            command.executeUpdate("update news set title='asdf' where id_news=3");
            res.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }*/

        NewsDriver news = new NewsDriver();
        for (News user: news.getNews()
             ) {
            System.out.println("" + user.getId_news());

        }

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
