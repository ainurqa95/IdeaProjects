package ru.mysite.web.models;


/**
 * Created by ainur on 23.10.16.
 */
public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("May");

    }
}
