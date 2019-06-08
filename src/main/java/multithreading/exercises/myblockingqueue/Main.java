package multithreading.exercises.myblockingqueue;

import java.util.Random;

/**
 * Task is to implement BlockingQueue without using a BlockingQueue data structure.
 */


public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>(3);

        Runnable producer = () -> {
            while (true) {
                int randomIntUpTo1000 = random.nextInt(1000);
                String newElement = String.valueOf(randomIntUpTo1000);
                myQueue.put(newElement);
                sleepThread(randomIntUpTo1000);
            }
        };

        Runnable consumer = () -> {
            while (true) {
                String element = myQueue.take();
                sleepThread(Long.valueOf(element));
            }
        };

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(producer);
        Thread t3 = new Thread(producer);
        Thread t4 = new Thread(consumer);
        Thread t5 = new Thread(consumer);
        Thread t6 = new Thread(consumer);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

    private static void sleepThread(long randomIntUpTo1000) {
        try {
            Thread.sleep(randomIntUpTo1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
