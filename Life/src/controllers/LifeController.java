package controllers;
import models.MyLife;

/**
 * Created by Айнур on 17.09.2016.
 */
public class LifeController {

    public static void actionIndex (int n, int m, int kol,int generationsCount ) throws Exception {

        MyLife life = new MyLife(n,m); // создаем поле
        life.generatePole (kol);  // создаем поле
        for (int i = 0; i < generationsCount ; i++){
        life.showPole();  // показываем поле
        if (!life.nextGeneration())// если предыдущее покления совпадают
            break;
        }
        life.showPole();

    }



}
