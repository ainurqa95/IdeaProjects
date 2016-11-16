package ru.parsentev.models;

/**
 * Created by ainur on 16.11.16.
 */
public class MainCategory {
    int idmain_cat;
    String name;
    int status;
    int sort_order;

    public MainCategory(int idmain_cat, String name) {
        this.idmain_cat = idmain_cat;
        this.name = name;
    }

    public int getIdmain_cat() {
        return idmain_cat;
    }

    public void setIdmain_cat(int idmain_cat) {
        this.idmain_cat = idmain_cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MainCategory(int idmain_cat, String name, int status, int sort_order) {
        this.idmain_cat = idmain_cat;
        this.name = name;
        this.status = status;
        this.sort_order = sort_order;
    }
}
