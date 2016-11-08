package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Users;
import models.UsersTable;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    private int regID;


    public int getRegID() {
        return regID;
    }

    public void actionReg(ActionEvent actionEvent) throws NoSuchAlgorithmException {
        UsersTable usersTable = new UsersTable();
        if(txtFIO.getText()!= ""&& txtLogin.getText()!="" && password.getText()!=""){
            String hashedPass;
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(password.getText().getBytes()); // вычисляем hash от cообщения и id
            byte[] digest = md5.digest();
            BigInteger h = new BigInteger(1,digest);
            hashedPass = h.toString();
            usersTable.insert(txtFIO.getText(), txtLogin.getText(), hashedPass);
            txtLogin.setVisible(false);
            txtFIO.setVisible(false);
            btnReg.setVisible(false);
            password.setVisible(false);
            labelPass.setVisible(false);
            Users user = usersTable.getUserByLogin(txtLogin.getText());
            if(user!= null){
                this. regID = user.getId();
              idLabel.setText(" Вы успешно зарегестрировались ваш id = " +String.valueOf(regID));

            }
        }

    }
}
