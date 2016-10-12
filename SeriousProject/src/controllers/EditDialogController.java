package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.AddressBookCollection;
import models.Person;

/**
 * Created by Айнур on 24.09.2016.
 */
public class EditDialogController {


    @FXML
    private Button btnAdd;
    @FXML
    private Button btnCancel;
    @FXML
    private TextField txtFdName;
    @FXML
    private TextField txtFdPhone;
    @FXML
    private TextField txtFdId;


    private Person personToEdit;
    private AddressBookCollection mybook;


    public void setPerson ( Person selectedPerson){ // в текстове поля заносим информацию о выбранном польователе

        this.personToEdit = selectedPerson; // перекидываем ссылку на объект который мы выбрали в таблице
        txtFdName.setText(selectedPerson.getFIO());
        txtFdPhone.setText(selectedPerson.getPhone());
        txtFdId.setText(selectedPerson.getId());

    }

    public Person getPersonToEdit() {
        return personToEdit;
    }

    public void actionClose(ActionEvent actionEvent) { // при нажатии на кнопку закрыть
        Node source =  (Node)   actionEvent.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.hide();//  т.е это окно всегда есть в памяти мметод hide его скрывает просто
    }
    public void actionSave (ActionEvent actionEvent){
        personToEdit.setFIO(txtFdName.getText()); // когда  мы меняем что-нибудь в этом объекте меняется меняется
        // объект который мы сейчас редактируем благодаря SimpleStringProperty
        personToEdit.setPhone(txtFdPhone.getText());

         personToEdit.setId(txtFdId.getText());

        actionClose(actionEvent);// сохраняем и закрываем


    }

}
