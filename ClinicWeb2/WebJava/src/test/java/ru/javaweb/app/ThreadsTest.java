package ru.javaweb.webProject;

import junit.framework.Assert;
import org.junit.Test;
import threads.Counter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ainur on 24.10.16.
 */
public class ThreadsTest {
    @Test
    public void testThread() throws InterruptedException {
        final Counter counter = new Counter();

        final List<Reader> readers =  Arrays.asList(new Reader(counter), new Reader(counter), new Reader(counter),
        new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter),
                new Reader(counter), new Reader(counter), new Reader(counter), new Reader(counter));
        for(final Reader reader : readers){

            reader.start();
        }
        Thread.sleep(10001);
        Assert.assertEquals(1201, counter.increase());
    }



    private static final class Reader extends Thread{
            private final  Counter counter;


        public Reader(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i != 10 ; ++i) {
                System.out.println( "id = " +Thread.currentThread().getId()+ " counter = " + this.counter.increase());

            }
        }
    }

}
