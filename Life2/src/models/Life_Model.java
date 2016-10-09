package models;

/**
 * Created by Айнур on 24.09.2016.
 */
public interface Life_Model {
    public void next();
    public int Get_size();
    public boolean Get_state(int i,int j) throws Exception;
    public void Set_state(int i,int j,boolean s) throws Exception;

      static  public Life_Model Create (){
          return new Life();
      }
}
