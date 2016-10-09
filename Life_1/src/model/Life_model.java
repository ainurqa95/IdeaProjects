package model;

/**
 * Created by Jaha on 20.09.2016.
 */
public interface Life_model {
    public void next();
    public int Get_size();
    public boolean Get_state(int i,int j) throws Exception;
    public void Set_state(int i,int j,boolean s) throws Exception;

    static public Life_model Create (){return new Life();}
}
