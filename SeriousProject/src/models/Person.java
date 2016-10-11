package models;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Айнур on 03.10.2016.
 */
public class Person {

    private SimpleStringProperty FIO = new SimpleStringProperty(""); // класс позоляет при изменении объекта персон сразу менять значения в таблице без update
    private SimpleStringProperty Phone = new SimpleStringProperty("");

    public Person ( String FIO, String Phone){

        this.FIO =  new SimpleStringProperty(FIO);
        this.Phone = new SimpleStringProperty(Phone);
    }
    public void setFIO(String FIO){
        this.FIO.set(FIO);
    }
    public void setPhone (String Phone){
        this.Phone.set(Phone);
    }
    public String getFIO ( ){

      return  this.FIO.get();
    }
    public String getPhone ( ){

        return  this.Phone.get();

    }
    public SimpleStringProperty getFioProperty (){
        return  this.FIO;
    }
    public SimpleStringProperty getPhoneProperty (){
        return  this.Phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "FIO='" + FIO + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
