package models;

import interfaces.Pet;

/**
 * Created by ainur on 23.10.16.
 */
public class Animal implements Pet {

    private final String name;

    public String getName() {
        return this.name;
    }

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("hello");
    }
}
