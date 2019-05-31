package multithreading.exercises.stoppingthetask;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Example1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask task = new MyTask();

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        Future<String> submit = executorService.submit(task);
        executorService.schedule(task::stop, 1, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println(submit.get());
    }

    private static class MyTask implements Callable<String> {

        private AtomicBoolean shouldWork = new AtomicBoolean(true);

        @Override
        public String call() throws InterruptedException {
            synchronized (Thread.currentThread()) {
                while (shouldWork.get()) {
                    System.out.println("Working");
                    Thread.currentThread().wait(700);
                }
                System.out.println("End of callable working.");
            }

            return "Callable is returning a value";
        }

        void stop() {
            shouldWork.set(false);
        }
    }

}


