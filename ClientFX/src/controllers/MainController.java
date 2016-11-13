package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Client;
import models.NetworкConnection;
import models.Users;
import models.UsersTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {


    private boolean isServer = false;
    @FXML
    Label labelStatus;

    @FXML
    TextArea clientAnswer;
    @FXML
    TextArea serverAnswer;
    @FXML
    TextField txtFdMessage;
    @FXML
    TextField txtIP;

    @FXML
    TextField txtPort;

    LinkedList<String> publicKeys = new LinkedList<String>();// публичные ключи RSA
    LinkedList<String> publicDH = new LinkedList<String>(); // g, p, A от сервера


    private NetworкConnection connection;

    private Stage mainStage;
    @FXML
    private Parent fxmlReg;
    private FXMLLoader fxmlLoaderREG = new FXMLLoader();
    private RegController regController;
    private Stage regStage;
    private String id;
    private BigInteger b;
    private BigInteger B;
    private BigInteger commonKey;
    private String login;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void connect(ActionEvent actionEvent) {

        if(txtIP.getText()!="" && txtPort.getText() !="") {
            connection = createClient(txtIP.getText(), Integer.parseInt(txtPort.getText()));
            labelStatus.setText(  "Клиент" );
            connection.startConnection();
        }
    }

    @FXML
    public void initialize(){


            try{

                this.fxmlLoaderREG.setLocation(getClass().getResource("../views/reg.fxml")); //
                this.fxmlReg  =  this.fxmlLoaderREG.load();                // нашему root присваиваем ресурс xml edit
                this.regController =  this.fxmlLoaderREG.getController();            // с помощью ссылки на этот контроллер можем манипулировать данными

            }
            catch (IOException e){
                e.printStackTrace();
            }

    }
    public void stop() throws IOException {

        connection.closeConnection();
    }

    private Client createClient (String IP, int port){
        // 127.0.0.1   5324
        return new Client("127.0.0.1", 5324, data -> {
            Platform.runLater(()-> {
                        serverAnswer.appendText(data.toString()+ "\n");
                    }
            );
        });
    }

    public void sendMessage(ActionEvent actionEvent) { // закидывает сообщения клиента на сервер
        String message = " Клиент : ";
        message+=  txtFdMessage.getText();
        txtFdMessage.clear();
        clientAnswer.appendText(message+"\n");

        try {
            connection.send(message);

        } catch (IOException e) {
            clientAnswer.appendText("ERROR");
            e.printStackTrace();
        }

    }
/**
* регистрация пользовател
* */
    public void registration(ActionEvent actionEvent) {
        if( this.regStage==null){ //
            this.regStage = new Stage();
            this.regStage.setTitle("Поле");
            this.regStage.setMinHeight(300);
            this.regStage.setMinWidth(500);
            this.regStage.setResizable(true);
            this.regStage.setScene(new Scene(fxmlReg));// берем из fxml

        }


        this.regStage.showAndWait();
        labelStatus.setText("Ваш id = "+ regController.getRegID());
    }




    public void getPublicKeyRSA(){ // просматриваем и закидываем клиенту информацию о публичныйх ключах
     // которую нам передал серве

        Pattern p1 = Pattern.compile("[0-9]+");
        String testStr = this.serverAnswer.getText();
        Matcher m = p1.matcher(testStr);

        while(m.find()) {
            publicKeys.add(testStr.substring(m.start(), m.end()));

        }
        System.out.println(publicKeys.get(0));

    }

    /**
     *
     * посылаем на сервер id , m , coded
     * @param actionEvent
     * @throws NoSuchAlgorithmException
     */
    public void decryptMessagID(ActionEvent actionEvent) throws NoSuchAlgorithmException {
        if(!this.clientAnswer.getText().equals("")){ // отправляем на сервер

            getPublicKeyRSA();
            Pattern p1 = Pattern.compile("\"[^\"]*\""); // с помощью регулярок парсим слова в кавычках
            String testStr = this.clientAnswer.getText(); // имеем id m coded

            String message ="";
            Matcher m = p1.matcher(testStr);
            while(m.find()) {
                message += testStr.substring(m.start()+1, m.end()-1); // +1 -1 чтобы убрать кавычки

            }

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(message.getBytes()); // вычисляем hash от cообщения и id
            byte[] digest = md5.digest();
            BigInteger h = new BigInteger(1,digest);



            BigInteger exp = new BigInteger(publicKeys.get(0));
            BigInteger n = new BigInteger(publicKeys.get(1));
            BigInteger coded = h.modPow(exp,n);
            String codedString = coded.toString();
            this.clientAnswer.appendText(" Клиент : coded = \"" +codedString+"\"\n");

            try {
                this.connection.send(" Клиент : coded = \"" +codedString+"\"");

            } catch (IOException e) {
                this.clientAnswer.appendText("ERROR");
                e.printStackTrace();
            }


        }
        else{

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Вы не передали id и сообщение для аутентификации");

            alert.showAndWait();
        }
    }

    public void getPublicKeyDH(){

        Pattern p1 = Pattern.compile("\"[^\"]*\"");
        String testStr = this.serverAnswer.getText();
        Matcher m = p1.matcher(testStr);

        while(m.find()) {
            publicDH.add(testStr.substring(m.start()+1, m.end()-1));

        }


    }
    public void getDHP(ActionEvent actionEvent) { // берем g,p, A переданные сервером
        getPublicKeyDH();
        SecureRandom rnd = new SecureRandom();
        this.b = BigInteger.probablePrime(512, rnd);
        BigInteger g = new BigInteger(publicDH.get(0));
        BigInteger p = new BigInteger(publicDH.get(1));
        BigInteger A = new BigInteger(publicDH.get(2));
        this.B = g.modPow(b,p);
        String mes = this.B.toString();
        this.clientAnswer.appendText(" Клиент : B = \"" +mes+"\"\n");
        this.commonKey = A.modPow(this.b, p);
        System.out.println("this commmon key =  " + this.commonKey.toString());
        try {
            this.connection.send(" Клиент : B = \"" +mes+"\"");

        } catch (IOException e) {
            this.clientAnswer.appendText("ERROR");
            e.printStackTrace();
        }



    }

    public void clearAnswers(ActionEvent actionEvent) {
        this.clientAnswer.setText("");
        this.serverAnswer.setText("");
    }

    public void sendHash(ActionEvent actionEvent) throws NoSuchAlgorithmException {


        Pattern p1 = Pattern.compile("\"[^\"]*\""); // с помощью регулярок парсим слова в кавычках
        String testStr = this.serverAnswer.getText();
        String strBigNFromServer ="";
        Matcher m = p1.matcher(testStr);
        while(m.find()) {
            strBigNFromServer = testStr.substring(m.start()+1, m.end()-1); // +1 -1 чтобы убрать кавычки
        }  // взяли большое N которое пришло с сервера
        testStr = this.clientAnswer.getText(); //
         m = p1.matcher(testStr);
        String strLogin = "";
        while (m.find()) {
            strLogin = testStr.substring(m.start() + 1, m.end() - 1); // ищем логин в окне клиента
        } // находим login который вбил пользователь
        UsersTable users = new UsersTable();

        Users user = users.getUserByLogin(strLogin);
        String hashedPass = user.getPassword(); // находим пароль пользователя
        System.out.println("big N = "+ strBigNFromServer);
        System.out.println("hashed pass = " + hashedPass);
        String svertka = strBigNFromServer + hashedPass; // нашли сверку N + password
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.reset();
        md5.update(svertka.getBytes()); // вычисляем hash от N + password
        byte[] digest = md5.digest();
        BigInteger h1 = new BigInteger(1,digest);
        String hash1 = h1.toString(); // отправляем hash1 на сервер
        this.clientAnswer.appendText(" Клиент : hash1 = \"" +hash1+"\"\n");

        try {
            this.connection.send(" Клиент : hash1 = \"" +hash1+"\"");

        } catch (IOException e) {
            this.clientAnswer.appendText("ERROR");
            e.printStackTrace();
        }

    }
}
