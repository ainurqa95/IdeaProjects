package ru.mysite.web.models;


import ru.mysite.web.interfaces.Pet;

/**
 * Created by ainur on 23.10.16.
 */
public class CatDog implements Pet {
    private final Cat cat;
    private final Dog dog;

    public CatDog(Cat cat, Dog dog) {
        this.cat = cat;
        this.dog = dog;
    }

    public void makeSound() {
        this.cat.makeSound();
        this.dog.makeSound();
    }

    public String getName() {
        return this.cat.getName() + this.dog.getName();
    }
}
