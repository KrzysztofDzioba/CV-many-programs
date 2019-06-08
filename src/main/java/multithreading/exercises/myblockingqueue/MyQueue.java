package multithreading.exercises.myblockingqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class MyQueue<E> {

    private Queue<E> myQueue;
    private volatile int maxSize;

    private ReentrantLock lock = new ReentrantLock();
    private Condition queueEmpty = lock.newCondition();
    private Condition queueFull = lock.newCondition();

    MyQueue(int maxSize) {
        this.maxSize = maxSize;
        myQueue = new LinkedList<>();
    }

    void put(E element) {
        lock.lock();
        try {
            if (myQueue.size() >= maxSize) {
                awaitCondition(queueFull);
            }
                myQueue.add(element);
                System.out.println("Producer put " + element + " and the size of queue is " + myQueue.size());
                queueEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    E take() {
        lock.lock();
        try {
            if (myQueue.size() == 0) {
                awaitCondition(queueEmpty);
            }
                queueFull.signal();
                E element = myQueue.poll();
                System.out.println("Consumer is consuming " + element);
                return element;
        } finally {
            lock.unlock();
        }
    }

    private void awaitCondition(Condition condition) {
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
