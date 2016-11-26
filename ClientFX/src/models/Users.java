package models;

/**
 * Created by ainur on 04.11.16.
 */
public class Users {
    private int id;
    private String fio;
    private String login;
    private String password;
    private String publicN;
    private String publicE;
    private String privateKey;

    public Users(int id, String fio, String login, String password, String publicN, String publicE, String privateKey) {
        this.id = id;
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.publicN = publicN;
        this.publicE = publicE;
        this.privateKey = privateKey;
    }

    public String getPublicN() {
        return publicN;
    }

    public String getPublicE() {
        return publicE;
    }

    public String getPrivateKey() {
        return privateKey;
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
