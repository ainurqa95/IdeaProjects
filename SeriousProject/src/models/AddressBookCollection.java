package models;

import interfaces.AddresBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import java.util.ArrayList;
import java.util.*;
/**
 * Created by Айнур on 03.10.2016.
 */
public class AddressBookCollection implements AddresBook {

    private ObservableList<Person> humanList = FXCollections.observableArrayList(); // специальная коллекция для TsblrView


    public void addPerson (Person human){
            humanList.add(human);

    }
    public void deletePerson (Person human){
        humanList.remove(human);

    }
    public void updateHuman(Person human){

    }

    public ObservableList<Person> getHumanList() {
        return humanList;
    }

    public void print (){
        for ( Person item : humanList
             ) {

            System.out.println("fio = " + item.getFIO() + " phone = " + item.getPhone());

        }
    }
    public void addTestValues (){
        humanList.add(new Person("Айнур","89274269594"));
        humanList.add(new Person("Динар","89274269594"));
        humanList.add(new Person("Радмир","89274269594"));
        humanList.add(new Person("Артур","89274269594"));
        humanList.add(new Person("Матур","89274269594"));

    }
}
