package view;


import model.Life_model;

/**
 * Created by Jaha on 20.09.2016.
 */
public class display {

    public static void main( String[] args ) throws Exception {
        Life_model generation = Life_model.Create();
        //количество шагов
        for (int i = 0; i < 10; i++) {
            System.out.println( toString(generation));
            generation.next( );
        }
    }


    public static String toString(Life_model A ) throws Exception {
        String result = "";
        for (int row = 0; row < A.Get_size(); row ++) {

            for (int col = 0; col < A.Get_size(); col ++) {
                result = result + (A.Get_state(row,col)? "X" : ".");
            }
            result = result + "\n";
        }
        return result;
    }
}