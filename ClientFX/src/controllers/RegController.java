package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Users;
import models.UsersTable;

import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * Created by ainur on 04.11.16.
 */
public class RegController {

    @FXML
    TextField txtFIO;
    @FXML
    TextField txtLogin;
    @FXML
    Label idLabel;
    @FXML
    Label labelPass;
    @FXML
    Button btnReg;

    @FXML
    PasswordField password;

    @FXML
    TextField publicKeyNTxt;

    @FXML
    TextField publicKeyETxt;

    @FXML
    TextField privateKeyTxt;

    @FXML
    Label publicKeyNLabel;

    @FXML
    Label publicKeyELabel;

    @FXML
    Label privateKeyLabel;



    private int regID;
    private BigInteger privateKey;
    private BigInteger publicKeyN;
    private BigInteger publicKeyE;

    @FXML
    public void initialize(){


        keysVisible(false);

    }
    public void keysVisible (boolean flag){

        privateKeyTxt.setVisible(flag);
        publicKeyNTxt.setVisible(flag);
        publicKeyETxt.setVisible(flag);
        privateKeyLabel.setVisible(flag);
        publicKeyNLabel.setVisible(flag);
        publicKeyELabel.setVisible(flag);

    }


    public int getRegID() {
        return regID;
    }

    public BigInteger getPrivateKey() {
        return privateKey;
    }

    public BigInteger getPublicKeyN() {
        return publicKeyN;
    }

    public BigInteger getPublicKeyE() {
        return publicKeyE;
    }

    public void actionReg(ActionEvent actionEvent) throws NoSuchAlgorithmException, InvalidKeySpecException {
        UsersTable usersTable = new UsersTable();
        if(txtFIO.getText()!= ""&& txtLogin.getText()!="" && password.getText()!=""){
            String hashedPass;
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(password.getText().getBytes()); // вычисляем hash от cообщения и id
            byte[] digest = md5.digest();
            BigInteger h = new BigInteger(1,digest);
            hashedPass = h.toString();
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(512);
            KeyPair kp = kpg.genKeyPair();

            // формируем ключи
            KeyFactory fact = KeyFactory.getInstance("RSA");
            RSAPublicKeySpec pub = fact.getKeySpec(kp.getPublic(),
                    RSAPublicKeySpec.class);
            RSAPrivateKeySpec priv = fact.getKeySpec(kp.getPrivate(),
                    RSAPrivateKeySpec.class);

            this.publicKeyN = (BigInteger)pub.getModulus();
            this.publicKeyE = (BigInteger)pub.getPublicExponent();
            this.privateKey = (BigInteger)priv.getPrivateExponent();



            usersTable.insert(txtFIO.getText(), txtLogin.getText(), hashedPass,publicKeyN.toString(),publicKeyE.toString(),this.privateKey.toString());
            txtLogin.setVisible(false);
            txtFIO.setVisible(false);
            btnReg.setVisible(false);
            password.setVisible(false);
            labelPass.setVisible(false);
            keysVisible(true);
            Users user = usersTable.getUserByLogin(txtLogin.getText());
            if(user!= null){
                this. regID = user.getId();
              idLabel.setText(" Вы успешно зарегестрировались ваш id = " +String.valueOf(regID));
                publicKeyETxt.setText(this.publicKeyE.toString());
                publicKeyNTxt.setText(this.publicKeyN.toString());
                privateKeyTxt.setText(this.privateKey.toString());

            }
        }

    }
}
