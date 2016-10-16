package controllers;

import models.MyLife;

/**
 * Created by ainur on 16.10.16.
 */
public class LifeController {
    private MyLife life;
    private int countLife;

    public void setLife(MyLife life, int countLife) {
        this.life = life; this.countLife = countLife;
    }
}
