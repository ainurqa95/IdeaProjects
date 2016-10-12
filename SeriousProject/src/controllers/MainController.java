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
import javafx.stage.Window;
import models.AddressBookCollection;
import models.Person;

import java.io.IOException;

public class MainController {
    private Stage mainStage; //

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

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
    private TableColumn<Person, String> tblColId; // колонка фио таблицы
    @FXML
    private TableColumn<Person,String> tblColFIO; // колонка фио таблицы
    @FXML
    private TableColumn<Person,String> tblColPhone;
    @FXML
    private Parent fxmlEdit;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private EditDialogController editDialogController;
    private Stage editDialogStage;

    @FXML
    private void initialize(){ // инициализируем начальную взаимосвязь xml с
        // tableAddressBook.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);// тогда можно будыт выбирать несколько записей в таблице
        // указываем какие поля из объекта персон будут хранятся в таблице
        tblColId.setCellValueFactory(new PropertyValueFactory<Person, String>("id"));
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

        try{
            fxmlLoader.setLocation(getClass().getResource("../fxml/edit.fxml"));
            fxmlEdit  = fxmlLoader.load();                // нашему root присваиваем ресурс xml edit
            editDialogController = fxmlLoader.getController();            // с помощью ссылки на этот контроллер можем манипулировать данными

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    private void updateCountLabel ( ){
        labelCount.setText("Количестов записей в адресной книге "+ mybook.getHumanList().size());

    }

    private void showDialog() { // при нажатии на кнопку добавить откроется модальное окно

            // вызывается при редатироании
            if(editDialogStage==null){ // инициализируем диалог
            editDialogStage = new Stage();
            editDialogStage.setTitle("Редактирование записи");
            editDialogStage.setMinHeight(300);
            editDialogStage.setMinWidth(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));// берем из fxml
            editDialogStage.initModality(Modality.WINDOW_MODAL); // говорим что окно модальное
            editDialogStage.initOwner(mainStage);// достаем информацию о родитеь=льском окне

            }
            //editDialogStage.show();
            editDialogStage.showAndWait(); // ожидать закрытие окна


    }

    public void buttonPressed(ActionEvent actionEvent) {
// при нажатии на кнопку добавить откроется модальное окно
        Person selectedPerson;

        Object source = actionEvent.getSource(); // определяем кто осуществил нажатие или действие button textfield и тд
        if(!(source instanceof Button))// если это не кнопка выход
            return;


        Button clickedButton = (Button)source; // делаем источник кнопкой
       //Window parentWindow = ((Node)actionEvent.getSource()).getScene().getWindow(); // берем родительское окно

        switch (clickedButton.getId()){ // смотри на какую же мы кнопку нажали

            case "buttonAdd":
                editDialogController.setPerson(new Person()); // заснули нового пользователя
                showDialog();  // в форме edit что-то изменили
                Person personAdd = editDialogController.getPersonToEdit(); // взяли добавленного
                mybook.addPerson(personAdd); // закинули его в коллекцию
                break;
            case "buttonDelete":
                 selectedPerson = (Person)tableAddressBook.getSelectionModel().getSelectedItem(); // получеам выбранного нами
                // человека в адресной книге
                mybook.deletePerson(selectedPerson);
                break;
            case "buttonChange":
                 selectedPerson = (Person)tableAddressBook.getSelectionModel().getSelectedItem(); // получеам выбранный обьект в
                editDialogController.setPerson(selectedPerson);
                showDialog();
                
                break;

        }



    }
}
