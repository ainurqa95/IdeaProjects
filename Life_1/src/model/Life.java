package model;

/**
 * Created by Jaha on 20.09.2016.
 */
/**
 * Created by Jaha on 18.09.2016.
 */
import java.io.*;
import java.util.Random;

 class Life implements Life_model {

     boolean[][] cells;


    // Кострукторы

    public void next (){

        int SIZE;
        SIZE=cells.length;
        boolean[][] tempCells = new boolean [SIZE] [SIZE];

        for( int i=0; i<SIZE; i++ ) {
            for( int j=0; j<SIZE; j++ ) {
                tempCells[i][j] = cells[i][j];
            }
        }
        for (int row = 0; row < cells.length ; row++)
        {
            for (int col = 0 ; col < cells[row].length ; col++)
            {
                if ( neighbours(row, col) > 3  ||  neighbours(row, col) < 2 )
                {
                    tempCells[row][col] = false;
                }
                else if (neighbours(row, col) == 3 )
                {
                    tempCells[row][col] = true;
                }

            }

        }
        cells = tempCells;

    }


    private int neighbours (int row, int col) {
        int alive_neigh=0;
        for ( int i = row -1; i <= row + 1 ; i++)
        {
            for (int j = col -1 ; j <= col + 1 ; j++)
            {
                try {
                    if (cells[i][j]==true && (i != row || j!=col))
                    {
                        alive_neigh++;
                    }
                } catch ( ArrayIndexOutOfBoundsException f)
                {continue;}
            }
        }
        return alive_neigh;
    }



    public Life( ) {
        final int SIZE = 5;

        final int[][] pairs = {{0,0},{1,1},{2,2},{3,3},{4,4}};
        cells = new boolean[ SIZE ][ ];
        for (int row = 0; row < SIZE; row ++) {
            cells[ row ] = new boolean[ SIZE ];
        }
        for (int pair = 0; pair < pairs.length; pair ++) {
            final int row = pairs[ pair ][ 0 ];
            final int col = pairs[ pair ][ 1 ];
            cells[ row ][ col ] = true;
        }
    }

     @Override
    public int Get_size (){

        return cells.length;
    }

    public boolean Get_state (int i, int j) throws Exception {


        if (i<0 || j<0 || i>= cells.length || j>=cells.length)
            throw new Exception("Ошибка индекса");
                    return cells[i][j];


    }
    public void Set_state (int i, int j,boolean s) throws Exception
    {
        if (i<0 || j<0 || i>= cells.length || j>=cells.length)
            throw new Exception("Ошибка индекса");
        cells[i][j]=s;
    }

}