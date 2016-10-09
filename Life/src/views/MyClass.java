package views;

import java.util.Scanner;
import models.MyLife;
import controllers.LifeController;

/**
 * Created by Айнур on 13.09.2016.
 */
public class MyClass {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число строк ");
        int n = scan.nextInt();
        System.out.println("Введите число столбцов ");
        int m = scan.nextInt();
        System.out.println("Введите количество жизней ");
        int kol = scan.nextInt();
        System.out.println("Введите количество поколений ");
        int generationCount = scan.nextInt();

       // LifeController.actionIndex(n,m, kol,generationCount);

        MyLife life = new MyLife(n,m); // создаем поле
      //  life.generatePoleFile (kol);  // создаем поле
        life.generatePole(kol);
        for (int i = 0; i < generationCount ; i++){
            System.out.println(toString(life));  // показываем поле
            if (!life.nextGeneration())// если предыдущее покления совпадают
                break;
        }
        System.out.println(toString(life));





    }
    public static String toString(MyLife A ) throws Exception {
        String result = "";
        for (int row = 0; row < A.Get_size(); row ++) {

            for (int col = 0; col < A.Get_size(); col ++) {
                result = result + (A.Get_state(row,col)? "X" : "0");
            }
            result = result + "\n";
        }
        return result;
    }

}
