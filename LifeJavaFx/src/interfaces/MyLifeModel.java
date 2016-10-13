package interfaces;

import java.io.FileNotFoundException;

/**
 * Created by ainur on 13.10.16.
 */
public interface MyLifeModel {

    public void generatePole ( int kol) throws FileNotFoundException;
    public boolean nextGeneration ();
    public boolean Get_state (int i, int j) throws Exception;
    public void Set_state (int i, int j,boolean s) throws Exception;
    public int Get_size ();
}
