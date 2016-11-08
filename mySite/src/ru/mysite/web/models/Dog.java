package ru.mysite.web.models;

import ru.mysite.web.interfaces.Pet;


/**
 * Created by ainur on 23.10.16.
 */
public class Dog implements Pet {

    private final Pet pet;


    public Dog(final Pet pet) {
        this.pet = pet;
    }

    public void makeSound() {
        System.out.println("Gav");

    }

    public String getName() {
        return  this.pet.getName();
    }
}
