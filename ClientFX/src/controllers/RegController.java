package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Users;
import models.UsersTable;

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
    Button btnReg;

    private int regID;

    public int getRegID() {
        return regID;
    }

    public void actionReg(ActionEvent actionEvent) {
        UsersTable usersTable = new UsersTable();
        if(txtFIO.getText()!= ""&& txtLogin.getText()!=""){
            usersTable.insert(txtFIO.getText(), txtLogin.getText());
            txtLogin.setVisible(false);
            txtFIO.setVisible(false);
            btnReg.setVisible(false);
            Users user = usersTable.getUserByLogin(txtLogin.getText());
            if(user!= null){
                this. regID = user.getId();
              idLabel.setText(" Вы успешно зарегестрировались ваш id = " +String.valueOf(regID));

            }
        }

    }
}
