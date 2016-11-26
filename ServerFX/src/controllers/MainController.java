package controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.NetworкConnection;
import models.Server;
import models.Users;
import models.UsersTable;

import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {


    private boolean isServer = true;
    @FXML
    Label labelStatus;

    @FXML
    TextArea serverAnswer;
    @FXML
    TextArea clientAnswer;
    @FXML
    TextField txtFdMessage;

    @FXML
    Button btnStart;
   
    private NetworкConnection connection = createServer();

    private Stage mainStage;
    @FXML
    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();

    private BigInteger e;
    private BigInteger n;
    private BigInteger d;

    private BigInteger a;
    private BigInteger g;
    private BigInteger p;
    private BigInteger A;

    private BigInteger commonKey;

    private BigInteger BigN;
    private String password;

    Pattern p1 = Pattern.compile("\"[^\"]*\"");
    public void stop() throws IOException {
        labelStatus.setText( "Сервер остановлен" );
        connection.closeConnection();
    }


    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    private Server createServer (){
        return new Server(5324, data -> {

            Platform.runLater(()-> {
                clientAnswer.appendText(data.toString()  + "\n");
                labelStatus.setText("Сервер запущен " + "клиент подключился");
                    }

            );

        });

    }



    public void startServer(ActionEvent actionEvent) {

        labelStatus.setText( "Сервер запущен" );
        connection.startConnection();


    }

    public void sendMessage(ActionEvent actionEvent) {
       String message = " Сервер : ";
       message+=  txtFdMessage.getText();
        txtFdMessage.clear();
        serverAnswer.appendText(message+"\n");

        try {
            connection.send(message);

        } catch (IOException e) {
            serverAnswer.appendText("ERROR");
            e.printStackTrace();
        }

    }

    public void stopServer(ActionEvent actionEvent) throws IOException {
        stop();
        this.labelStatus.setText("Сервер остановлен");
    }

    public void saveToFile(String fileName, BigInteger mod, BigInteger exp) throws IOException {
        ObjectOutputStream oout = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName)));
        try {
            oout.writeObject(mod);
            oout.writeObject(exp);
        } catch (Exception e) {
            throw new IOException("Unexpected error", e);
        } finally {
            oout.close();
        }
    }

    PublicKey readKeyFromFile(String keyFileName) throws IOException {
        InputStream in = NetworкConnection.class.getResourceAsStream(keyFileName);
        ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(in));
        try {
            BigInteger m = (BigInteger) oin.readObject();
            BigInteger e = (BigInteger) oin.readObject();
            System.out.println(m);
            System.out.println(e);
            RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
            KeyFactory fact = KeyFactory.getInstance("RSA");
            PublicKey pubKey = fact.generatePublic(keySpec);
            return pubKey;
        } catch (Exception e) {
            throw new RuntimeException("Spurious serialisation error", e);
        } finally {
            oin.close();
        }
    }

    public void generateKeysRSA(ActionEvent actionEvent) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(512);
        KeyPair kp = kpg.genKeyPair();
        Key publicKey = kp.getPublic();
        Key privateKey = kp.getPrivate();
        // формируем ключи
        KeyFactory fact = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec pub = fact.getKeySpec(kp.getPublic(),
                RSAPublicKeySpec.class);
        RSAPrivateKeySpec priv = fact.getKeySpec(kp.getPrivate(),
                RSAPrivateKeySpec.class);

         this.n = (BigInteger)pub.getModulus();
         this.e = (BigInteger)pub.getPublicExponent();
         this.d = (BigInteger)priv.getPrivateExponent();

        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(n, e);
        PublicKey pubKey = fact.generatePublic(keySpec);
        String message="";
        message+= "Сервер : e = \""+ this.e+"\"\n"; //отправляем e и n на сервер
        message+= "Сервер : n = \""+ this.n+"\"\n";
        // сформировали публичные ключи е и n и отправили их клиенту
        serverAnswer.appendText(message+"\n");

        try {
            connection.send(message);

        } catch (IOException e) {
            clientAnswer.appendText("ERROR");
            e.printStackTrace();
        }

    }

    public void authentification(ActionEvent actionEvent) throws NoSuchAlgorithmException {
        if(this.clientAnswer.getText()!=""){

            LinkedList<String> clientMessage = new LinkedList<>();

            String testStr = this.clientAnswer.getText();
               String message ="";
            Matcher m = p1.matcher(testStr);
            while(m.find()) {
                clientMessage.add(testStr.substring(m.start()+1, m.end()-1));

            }
            UsersTable users = new UsersTable();
            Users user = users.getUserByLogin(clientMessage.get(0));
            if(user == null){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText(null);
                alert.setContentText("Нет такого id в базе ");


                alert.showAndWait();
                this.serverAnswer.appendText(" Сервер : такого логина нет \n");

                try {
                    this.connection.send(" Сервер : такого логина нет \n");

                } catch (IOException e) {
                    this.serverAnswer.appendText("ERROR");
                    e.printStackTrace();
                }
                return;
            }

            message=user.getLogin()+user.getPassword();  // id+ message
            System.out.println(message);

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(message.getBytes());
            byte[] digest = md5.digest();
            BigInteger h1 = new BigInteger(1,digest);
            // нашли хэш h1 = hash(id,m+ts)


            BigInteger sign = new BigInteger(clientMessage.get(1)); // второй параметр это подпись
            BigInteger h2 = sign.modPow(new BigInteger(user.getPublicE()), new BigInteger(user.getPublicN()));
            System.out.println("h2 = " + h2.toString() );
            if (h1.equals(h2)){ //если h1 == h2 все нормаьно
                this.serverAnswer.appendText(" Сервер : вы успешно прошли аутентификацию \n");

                try {
                    this.connection.send(" Сервер : вы успешно прошли аутентификацию \n");

                } catch (IOException e) {
                    this.serverAnswer.appendText("ERROR");
                    e.printStackTrace();
                }


            }
            else {
                this.serverAnswer.appendText(" Сервер : вы не прошли аутентификацию, подпись не верна \n");

                try {
                    this.connection.send(" Сервер : вы не прошли аутентификацию подпись не верна \n");

                } catch (IOException e) {
                    this.serverAnswer.appendText("ERROR");
                    e.printStackTrace();
                }


            }


        }
    }


    public void generateDifHel(ActionEvent actionEvent) throws NoSuchAlgorithmException, InvalidKeySpecException {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DiffieHellman");
        kpg.initialize(512);
        KeyPair kp = kpg.generateKeyPair();
        KeyFactory kfactory = KeyFactory.getInstance("DiffieHellman");

        DHPublicKeySpec kspec = (DHPublicKeySpec) kfactory.getKeySpec(kp.getPublic(),
                DHPublicKeySpec.class);
        this.g = (BigInteger)kspec.getG();
        this.p = (BigInteger)kspec.getP();
        this.a = (BigInteger)kspec.getY();
        this.A = this.g.modPow(this.a, this.p);
        SecureRandom rnd = new SecureRandom();
        BigInteger b = BigInteger.probablePrime(512, rnd);
        BigInteger B = this.g.modPow(b,this.p);
        String message="";
        message+= "Сервер : g = \""+ this.g+"\"\n";
        message+= "Сервер : p = \""+ this.p+"\"\n";
     //   message+= "Сервер : a = \""+ this.a+"\"\n";
        message+= "Сервер : A = \""+ this.A+"\"\n";
       // message+= "Сервер : b = \""+ b+"\"\n";
       // message+= "Сервер : B = \""+ B+"\"\n";
      //  message+= "Сервер : B^a mod p = \""+ B.modPow(a,p)+"\"\n";
      //  message+= "Сервер : A^b mod p = \""+ A.modPow(b,p)+"\"\n";
        // сформировали публичные ключи е и n и отправили их клиенту
        serverAnswer.appendText(message+"\n");

        try {
            connection.send(message);

        } catch (IOException e) {
            clientAnswer.appendText("ERROR");
            e.printStackTrace();
        }


    }

    public void createKey(ActionEvent actionEvent) { // берем B переданный клиентом

        String testStr = this.clientAnswer.getText(); //
        Matcher m = p1.matcher(testStr);
        String strB="";
        while(m.find()) {
            strB = testStr.substring(m.start()+1, m.end()-1);

        }
        BigInteger B = new BigInteger(strB);
        this.commonKey = B.modPow(a,p);
        // выведет в консоль общий ключ
        System.out.println("common key = "+ this.commonKey );
    }

    public void clearAnswers(ActionEvent actionEvent) {
        this.clientAnswer.setText("");
        this.serverAnswer.setText("");
    }

    public void checkLogin(ActionEvent actionEvent) {
        if(this.clientAnswer.getText()!="") {

            String testStr = this.clientAnswer.getText(); //
            Matcher m = p1.matcher(testStr);
            String strLogin = "";
            while (m.find()) {
                strLogin = testStr.substring(m.start() + 1, m.end() - 1); // bищем логин в окне клиента
            }

            UsersTable users = new UsersTable();
            Users user = users.getUserByLogin(strLogin);
            if(user!= null){  // если пользователь с таким логином есть
                String message = " Сервер : N = \"";
                SecureRandom rnd = new SecureRandom();
                this.BigN = BigInteger.probablePrime(512, rnd);
                this.password = user.getPassword();
                message +=  this.BigN.toString()+"\"\n"; // отправляем большое число N
                serverAnswer.appendText(message);

                try {
                    connection.send(message);

                } catch (IOException e) {
                    clientAnswer.appendText("ERROR");
                    e.printStackTrace();
                }

            }else { // если пользователя с таким логином нет

                this.serverAnswer.appendText(" Сервер : вы не прошли аутентификацию \n");

                try {
                    this.connection.send(" Сервер : вы не прошли аутентификацию \n");

                } catch (IOException e) {
                    this.serverAnswer.appendText("ERROR");
                    e.printStackTrace();
                }

            }
        }
    }

    public void checkHash(ActionEvent actionEvent) throws NoSuchAlgorithmException {
        String svertka = this.BigN.toString() + this.password;
        System.out.println("big N = "+ this.BigN);
        System.out.println("hashed pass = " + this.password);


        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.reset();
        md5.update(svertka.getBytes()); // вычисляем hash от N + password
        byte[] digest = md5.digest();
        BigInteger h2 = new BigInteger(1,digest);
        String hashServer = h2.toString();
        String testStr = this.clientAnswer.getText(); //

        Matcher m = p1.matcher(testStr);
        String hashClient = "";
        while (m.find()) {
            hashClient = testStr.substring(m.start() + 1, m.end() - 1); // bищем hash в окне клиента
        }
        if(hashClient.equals(hashServer)){
            this.serverAnswer.appendText(" Сервер : вы успешно прошли аутентификацию \n");
            try {
                this.connection.send(" Сервер : вы успешно прошли аутентификацию \n");

            } catch (IOException e) {
                this.serverAnswer.appendText("ERROR");
                e.printStackTrace();
            }

        }else {
            this.serverAnswer.appendText(" Сервер : вы не прошли аутентификацию \n");
            try {
                this.connection.send(" Сервер : вы не прошли аутентификацию \n");

            } catch (IOException e) {
                this.serverAnswer.appendText("ERROR");
                e.printStackTrace();
            }
        }


    }
}
