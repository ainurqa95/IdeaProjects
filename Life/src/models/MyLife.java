package models;
import models.Pair;
import java.util.*;
import java.io.*;

/**
 * Created by Айнур on 13.09.2016.
 */
public class MyLife implements MyLifeModel {

    private int n, m;
    private boolean [][] pole;


   static List<Pair> neighbours = new ArrayList(); // спсок соседей
    public MyLife (int n, int m) throws Exception
    {


        if( n<= 0 || m <= 0) {
            throw new Exception("Ошибка размеров");
        }
        this.n = n;
        this.m = m;
        pole = new boolean[n][m];
        clear(this.pole);

    }
    public void clear (boolean [][]a){ // очистка поля
        for (int i =0; i < this.n; i++)
            for (int j =0 ; j < this.n; j++)
            {
                a[i][j] = false;

            }


    }
    public boolean compare (boolean [][] a, boolean [][] b)// сравнение двух матриц равны = тру
    {
        for (int i =0; i < this.n; i++)
            for (int j =0 ; j < this.n; j++)
                if(a[i][j] != b[i][j])
                    return false;


        return true;


    }
    public void generatePole ( int kol)
    {

        int new_i, new_j;
        Random rand = new Random(this.m);
        for (int k = 0; k < kol; k++) { // кол - колиичество жизней которые мы хотим создать
            while (true) {
                 new_i = rand.nextInt(this.n - 1); // генерируем индексы i , j
                 new_j = rand.nextInt(this.m - 1 );
                if (pole[new_i][new_j] == false) // смотрим заполнено ли уже с такими координатами поле
                {// если нет добавляем жизнь
                    pole[new_i][new_j] = true;
                    break;
                }// иначе продолжаем генерировать
            }


        }
    }
    public void generatePoleFile ( int kol) throws FileNotFoundException {

        Scanner scan = new Scanner(new BufferedReader(new FileReader("D://data.txt")));

       for (int k = 0; k < kol; k++)
       {
           int i = scan.nextInt();
           int j = scan.nextInt();
           if (i<this.n && j < this.m && i >= 0 && j >=0)
                 if (pole[i][j] == false)
                        pole[i][j] = true;

       }

    }
    public void readPointNeighbors(  int x,  int y) // ищем соседей клетки
    {

         int k = 0;

        for (int i = x - 1; i <= x + 1; i++) { // ходим вправ влево
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y || i < 0 || j < 0 || i > n-1 || j > n-1 ) {
                    continue;// пропускаем итерацию
                }
                Pair coord = new Pair();

                neighbours.add(new Pair(i,j)); // формируем список соседей
            }
        }
    }
    public int countNeighbours(int x, int y){ // количество соседей
         neighbours.clear();// чистим список соесдей
        this.readPointNeighbors(x,y); // списко всех соедей с индексами х и у
        int count = 0;

        for ( Pair coords: this.neighbours ) { // пробегаем по всем соседям
            if(this.pole[coords.cor_x][coords.cor_y] == true ){ // считаем жизни
                count++;

            }
        }

        return count;

    }

    public boolean nextGeneration (){
        int count;
        boolean [][] nextPole = new boolean[this.n][this.m];
        copyPole(nextPole,this.pole);
        for (int i =0; i < this.n; i++){
            for (int j =0 ; j < this.n; j++)
            {

                count = countNeighbours(i,j);
                if(this.pole[i][j] == false) { // у пустой клетки
                    if (count == 3) // три соседа будет жизнь
                        nextPole[i][j] = true;

                }else if(count < 2 || count > 3){ // у клетки которая жива не 2 и не 3 соседа
                        nextPole[i][j] = false;

                }
            }
        }
        if (compare(this.pole,nextPole))
            return false;

        copyPole(this.pole,nextPole);
        return true;
    }
    public void copyPole(boolean [][] a, boolean [][] b ){
        for (int i =0; i < this.n; i++)
            for (int j =0 ; j < this.n; j++)
                a[i][j] = b[i][j];

    }

    public void showPole (){
        String str = "";
        for (int i =0; i < this.n; i++){
            for (int j =0 ; j < this.n; j++)
              if(this.pole[i][j])
                  str+= "X ";
                  else str+= "0 ";
            System.out.println(str+ "\n");
            str = "";
            }
        System.out.println("\n");

    }
    public boolean Get_state (int i, int j) throws Exception {


        if (i<0 || j<0 || i>= this.pole.length || j>=this.pole.length)
            throw new Exception("Ошибка индекса");
        return this.pole[i][j];


    }

    public int Get_size (){

        return this.pole.length;
    }
    public void Set_state (int i, int j,boolean s) throws Exception
    {
        if (i<0 || j<0 || i>= this.pole.length || j>=this.pole.length)
            throw new Exception("Ошибка индекса");
        this.pole[i][j]=s;
    }




}


