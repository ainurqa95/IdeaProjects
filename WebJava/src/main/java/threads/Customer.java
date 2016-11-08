package threads;

import ru.javaweb.webProject.User;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ainur on 26.10.16.
 */
public  final class Customer extends Thread {
    private final BlockQueue<User> queue;
    private final AtomicInteger counter = new AtomicInteger(0);

    public Customer( final BlockQueue<User> queue) {
        super();
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("id thread = " +  Thread.currentThread().getId() + "  " +this.queue.poll());
            counter.incrementAndGet(); // count ++ сколько раз customers ждали своей очереди


        }
    }
    public int size (){

        return this.counter.get();
    }
}
