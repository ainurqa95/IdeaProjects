package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    private static double sizeX = 500;
    private static double sizeY = 500;
    double dx, dy;

    double radius = 30;
    @Override
    public void start(Stage primaryStage) throws Exception{
    //    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        final Group root = new Group();
        /*
        final Text label = new Text();
        label.setText("Введите имя");
        label.setLayoutX(50);
        label.setLayoutY(50);
        root.getChildren().add(label);// спсок всех элементов

        final  TextField input = new TextField();
        input.setMinWidth(20);
        input.setLayoutY(80);
        input.setLayoutX(50);
        root.getChildren().add(input);

        final  Button hello = new Button();
        hello.setText("Приветствие");
        hello.setLayoutX(50);
        hello.setLayoutY(120);

        final Text label1 = new Text();
        label1.setText("");
        label1.setLayoutX(150);
        label1.setFont(new Font("Arial",20));
        label1.setLayoutY(150);
        label1.setFill(Color.GREEN);
        root.getChildren().add(label1);

        hello.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {


                label1.setText("Привет "+ input.getText()+ "!");

            }
        });
        root.getChildren().add(hello);
        */
        final Circle c = new Circle();
        c.setCenterX(250);
        c.setCenterY(250);
        c.setRadius(radius);
        c.setFill(Color.AQUA);

        c.setOnMousePressed(new EventHandler<MouseEvent>() { // при нажатии на кружок
            @Override
            public void handle(MouseEvent mouseEvent) {
                dx = c.getCenterX() - mouseEvent.getSceneX(); // запоминаем чтобы когда мы перемещали круг наш круг не ходил центром за мышкой
                dy = c.getCenterY() - mouseEvent.getSceneY();
            }
        });
        c.setOnMouseDragged(new EventHandler<MouseEvent>() { // когда тянем круг
            @Override
            public void handle(MouseEvent mouseEvent) {
                    // должны изменить координаты центра и соответсвтенно координаты мыши
                double goY =  mouseEvent.getSceneY();
                double goX = mouseEvent.getSceneX()+dx;
                if(checkBorders(goX,goY,radius))
                  c.setCenterX(mouseEvent.getSceneX()+dx);
                goY =  mouseEvent.getSceneY()+ dy;
                if(checkBorders(goX,goY,radius))
                   c.setCenterY(mouseEvent.getSceneY()+dy);
            }
        });
        c.setOnMouseReleased(new EventHandler<MouseEvent>() { // когда отпустили
            @Override
            public void handle(MouseEvent mouseEvent) {

            }
        });
        root.getChildren().add(c);



        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, sizeX, sizeY)); // обработать выход за границы
        primaryStage.getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {// при нажатии на клавишу //
            @Override
            public void handle(KeyEvent keyEvent) { // при нажатии на кнопку UP наш круг будет вверх подниматься
                double goY;
                double goX;
                if(keyEvent.getCode() == KeyCode.UP) {
                     goY = c.getCenterY() - 5;
                     goX = c.getCenterX();
                    if(checkBorders(goX,goY,radius))
                         c.setCenterY(goY);

                }
                if(keyEvent.getCode() == KeyCode.LEFT) {
                     goY = c.getCenterY();
                     goX = c.getCenterX()- 5;
                    if(checkBorders(goX,goY,radius))
                    c.setCenterX(goX);
                }
                if(keyEvent.getCode() == KeyCode.RIGHT) {
                     goY = c.getCenterY();
                     goX = c.getCenterX()+ 5;
                    if(checkBorders(goX,goY,radius))
                      c.setCenterX(goX);

                }
                if(keyEvent.getCode() == KeyCode.DOWN) {

                    goY = c.getCenterY()+5;
                    goX = c.getCenterX();
                   if(checkBorders(goX,goY,radius))
                         c.setCenterY(goY);

                }

            }
        });

        primaryStage.show();
    }
    public static boolean checkBorders(double centerX, double centerY, double radius){
        double temp1 = centerX + radius;
        double temp2 = centerX - radius;
        double temp3 = centerY + radius;
        double temp4 = centerY - radius;
        if( temp4 < 0 || temp3 > sizeY || temp1 > sizeX || temp2 < 0)
            return false;
        return true;


    }


    public static void main(String[] args) {

        launch(args);
    }
}
