package models;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Айнур on 03.10.2016.
 */
public class Person {

    private SimpleStringProperty FIO;
    private String Phone;

    public Person ( String FIO, String Phone){

        this.FIO = FIO;
        this.Phone = Phone;
    }
    public void setFIO(String FIO){
        this.FIO = FIO;
    }
    public void setPhone (String Phone){
        this.Phone = Phone;
    }
    public String getFIO ( ){

      return  this.FIO;
    }
    public String getPhone ( ){

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
