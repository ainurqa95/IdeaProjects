package threads;

import models.Client;
import org.junit.Test;
import ru.javaweb.webProject.User;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import static org.junit.Assert.*;

/**
 * Created by ainur on 26.10.16.
 */
public class BlockQueueTest {

    @Test
    public void queue() throws InterruptedException {
    final BlockQueue<User> queue = new BlockQueue<User>();
    final List<Customer> customers = Arrays.asList(new Customer( queue), new Customer( queue));
   // Customer ждут данные
    for(Customer cast : customers) {
        cast.start(); // запускате поток а метод внутри него ран делает его параллельным

     }
     // Продюсер записывает очередь
     Producer producer = new Producer(queue,
             Arrays.asList(new User (1, "AInur"), new User(2, "Dinar"), new User(3,"Vita")));

        producer.start();
        // у нас есть основной поток - это родительский и дочерние которые были порождены в родительском потоке

        producer.join(); // если хотим чтобы все дочерние потоки родительского потока Thread были закончены до того
        // когда родительский поток закончится мы говорим нашему дочернему потоку, чтобы он присоединился в родительский поток
        Thread.sleep(101);
        int count = 0;
        for (Customer customer : customers){

            count+= customer.size();
        }
        System.out.println(count);
        assertEquals(count, producer.size_users());
    }

}
