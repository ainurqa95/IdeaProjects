package views;
import models.Life_Model;
/**
 * Created by Айнур on 24.09.2016.
 */
public class display {
    public static void main( String[] args ) throws Exception {
        Life_Model generation = Life_Model.Create();
        //количество шагов
        for (int i = 0; i < 10; i++) {
            System.out.println( toString(generation));
            generation.next( );
        }
    }


    public static String toString(Life_Model A ) throws Exception {
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
