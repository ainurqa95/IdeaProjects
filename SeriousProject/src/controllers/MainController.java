package controllers;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.AddressBookCollection;
import models.Person;

import java.io.IOException;

public class MainController {

    private AddressBookCollection mybook = new AddressBookCollection();
    // fx id всех элементов вьюхи
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonChange;
    @FXML
    private Button butonSearch;
    @FXML
    private TableView tableAddressBook;
    @FXML
    private Label labelCount;
    @FXML
    private TableColumn<Person,String> tblColFIO; // колонка фио таблицы
    @FXML
    private TableColumn<Person,String> tblColPhone;

    @FXML
    private void initialize(){ // инициализируем начальную взаимосвязь xml с
        // tableAddressBook.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);// тогда можно будыт выбирать несколько записей в таблице
        // указываем какие поля из объекта персон будут хранятся в таблице
        tblColFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("FIO")); // ищет геттер в классе Person и вернет значение fio
        tblColPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("Phone"));

        mybook.addTestValues(); // заполняем наш observableList список людьми
        tableAddressBook.setItems(mybook.getHumanList()); // помещаем его в таблицу
        // tableView видит только observableList
        mybook.getHumanList().addListener(new ListChangeListener<Person>() {// реагирует на всяческие изменения в коллекции
            @Override
            public void onChanged(Change<? extends Person> change) { // при изменении в коллекции сработате этот метод
                updateCountLabel(); // и мы сразу перечитываем количесвто записей
            }
        });
        updateCountLabel();

    }
    private void updateCountLabel ( ){
        labelCount.setText("Количестов записей в адресной книге "+ mybook.getHumanList().size());

    }

    public void showDialog(ActionEvent actionEvent) { // при нажатии на кнопку добавить откроется модальное окно


        Object source = actionEvent.getSource(); // определяем кто осуществил нажатие или действие button textfield и тд
         if(!(source instanceof Button))// если это не кнопка выход
             return;

        Person selectedPerson = (Person)tableAddressBook.getSelectionModel().getSelectedItem(); // получеам выбранный обьект в таблице
        Button clickedButton = (Button)source; // делаем источник кнопкой

        switch (clickedButton.getId()){ // смотри на какую же мы кнопку нажали

            case "buttonAdd":
            System.out.println("add"+ selectedPerson.getFIO());
                break;
            case "buttonDelete":
                System.out.println("delete"+ selectedPerson.getFIO());
                break;
            case "buttonChange":
                System.out.println("change"+ selectedPerson.getFIO());
                break;

        }
        try {
            buttonAdd.setText("clicked");
            labelCount.setText("clicked");
            TableView x;
            Label y;
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/edit.fxml"));
            stage.setTitle("Редактирование записи");
            stage.setMinHeight(150);
            stage.setMinWidth(300);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL); // говорим что окно модальное
            stage.initOwner(((Node) actionEvent.getSource()).getScene().getWindow());// достаем информацию о родитеь=льском окне
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
