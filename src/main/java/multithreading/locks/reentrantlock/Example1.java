package multithreading.locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class Example1 {

    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args){
        Runnable r = Example1::lockAndPrintInfo;
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("End of starting threads");
    }

    private static void lockAndPrintInfo() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Locking the lock object in thread " + threadName);
        lock.lock();
        try {
            System.out.println("Current thread name: " + threadName +
                    ". Thread is going to sleep for 1 second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Queue length: " + lock.getQueueLength());
            System.out.println("Unlocking the lock from " + threadName);
            lock.unlock();
        }
    }
}
