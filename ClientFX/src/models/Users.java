package models;

/**
 * Created by ainur on 04.11.16.
 */
public class Users {
    private int id;
    private String fio;
    private String login;

    public Users(int id, String fio, String login) {
        this.id = id;
        this.fio = fio;
        this.login = login;
    }

    public Users(String fio, String login) {
        this.fio = fio;
        this.login = login;
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
