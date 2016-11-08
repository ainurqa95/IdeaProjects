package models;

import interfaces.Pet;

/**
 * Created by ainur on 23.10.16.
 */
public class Client {
    private int id;
    private Pet pet;

    public Client(int id, Pet pet) {
        this.id = id;
        this.pet = pet;
    }
}
