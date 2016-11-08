package threads;

import java.util.LinkedList;

/**
 * Created by ainur on 26.10.16.
 */
public class BlockQueue<T> {
    // очередь потоков
    public final LinkedList<T> queue = new LinkedList<T>();

    public void push (final T t){ //
        synchronized (this.queue){ // если я хочу работать с этой очередью я ее блокирую и начинаю с ней работать
             //
            this.queue.add(t);  // мы делаем lock этого объекта если он свободен записываем в очердь
            this.queue.notifyAll(); // говорит тем потокам, которые находятся в wait должны проснуться


        }// после выхода из блока  synchronized возобновиться работа потока в методе pull
    }
    public T poll (){
        synchronized (this.queue){

            while (this.queue.isEmpty()){ // очередь пустая
                try { // когда перевли в режим ожидания мы открываем lock и сюда заходит другой поток
                    this.queue.wait(); // то мы должны сказать чтобы Customer ждал, пока очередь не заполнится
                    // когда перевли в режим ожидания мы открываем lock и сюда заходит
                    // другой поток заходит в pull и делает this.queue.add(t);
                    // и он записывает
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        } // если никто не успел считаться
        return this.queue.remove(); // счаитываем данные

    }
}
