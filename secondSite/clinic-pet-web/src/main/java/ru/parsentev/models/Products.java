package ru.parsentev.models;

/**
 * Created by ainur on 16.11.16.
 */
public class Products {

    int idproducts;
    String name;
    double price;
    String description;
    String characteristic;
    int isNew;
    int isRecommended;
    int status;
    int idSecond;
    int idMain;

    public Products(int idproducts, String name, double price, String description, String characteristic, int isNew, int isRecommended, int status, int idSecond, int idMain) {
        this.idproducts = idproducts;
        this.name = name;
        this.price = price;
        this.description = description;
        this.characteristic = characteristic;
        this.isNew = isNew;
        this.isRecommended = isRecommended;
        this.status = status;
        this.idSecond = idSecond;
        this.idMain = idMain;
    }

    public int getIdproducts() {
        return idproducts;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public int getIsNew() {
        return isNew;
    }

    public int getIsRecommended() {
        return isRecommended;
    }

    public int getStatus() {
        return status;
    }

    public int getIdSecond() {
        return idSecond;
    }

    public int getIdMain() {
        return idMain;
    }
}
