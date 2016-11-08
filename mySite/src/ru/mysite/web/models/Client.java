package ru.mysite.web.models;


import ru.mysite.web.interfaces.Pet;

/**
 * Created by ainur on 23.10.16.
 */
public class Client {
    private int id;
    private Pet pet;
    private String client;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Client(int id, Pet pet, String client) {

        this.id = id;
        this.pet = pet;
        this.client = client;
    }

    public Client(int id, Pet pet) {
        this.id = id;
        this.pet = pet;
    }
}
