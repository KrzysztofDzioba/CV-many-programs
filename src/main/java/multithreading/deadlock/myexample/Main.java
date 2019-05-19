package multithreading.deadlock.myexample;

public class Main {

    private static final Object LOCK_1 = new Object();
    private static final Object LOCK_2 = new Object();

    public static void main(String[] args) {
        Runnable runnable1 = () -> {
            synchronized (LOCK_1) {
                System.out.println("Thread 1 in synchronizing lock_1");
                synchronized (LOCK_2) {
                    System.out.println("Thread 1 in synchronizing lock_2");
                }
            }
        };

        Runnable runnable2 = () -> {
            synchronized (LOCK_2) {
                System.out.println("Thread 2 in synchronizing lock_2");
                synchronized (LOCK_1) {
                    System.out.println("Thread 2 in synchronizing lock_1");
                }
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }

}
