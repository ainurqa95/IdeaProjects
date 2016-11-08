package threads;

/**
 * Created by ainur on 24.10.16.
 */
public class Counter {
    private int Count;
    public synchronized int increase (){
        Count++;
        return Count;
    }
}
