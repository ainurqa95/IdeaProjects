package ru.parsentev.models;

/**
 * Created by ainur on 16.11.16.
 */
public class SecondCategory {
    int id_second_cat;
    int id_main_cat;
    String name;
    int status;
    int sort_order;


    public int getId_second_cat() {
        return id_second_cat;
    }

    public void setId_second_cat(int id_second_cat) {
        this.id_second_cat = id_second_cat;
    }

    public int getId_main_cat() {
        return id_main_cat;
    }

    public void setId_main_cat(int id_main_cat) {
        this.id_main_cat = id_main_cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SecondCategory(int id_second_cat, int id_main_cat, String name) {
        this.id_second_cat = id_second_cat;
        this.id_main_cat = id_main_cat;
        this.name = name;
    }
}
