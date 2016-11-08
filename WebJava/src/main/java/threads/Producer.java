package threads;

import ru.javaweb.webProject.User;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Created by ainur on 26.10.16.
 */
public class Producer extends Thread {
    private final BlockQueue<User> queue;
    private final List<User> store;

    public Producer(BlockQueue<User> queue, List<User> store) {
        super();
        this.queue = queue;
        this.store = store;
    }
    public int size_users(){
        return this.store.size();

    }

    @Override
    public void run() {
       for (User user : store){

           this.queue.push(user);
       }
    }
}
