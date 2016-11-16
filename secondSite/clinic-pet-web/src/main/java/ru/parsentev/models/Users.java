package ru.parsentev.models;

/**
 * Created by ainur on 15.11.16.
 */
public class Users {

    private int id;
    private String fio;
    private String login;
    private String password;
    private int cityId;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public Users(int id, String fio, String login, String password, int cityId) {
        this.id = id;
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.cityId = cityId;
    }
    public Users( String fio, String login, String password, int cityId) {

        this.fio = fio;
        this.login = login;
        this.password = password;
        this.cityId = cityId;
    }

    public Users(int id, String fio, String login, String password) {
        this.id = id;
        this.fio = fio;
        this.login = login;
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users(String fio, String login, String password) {
        this.fio = fio;
        this.login = login;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}


