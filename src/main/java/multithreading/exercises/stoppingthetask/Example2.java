package multithreading.exercises.stoppingthetask;

import java.util.concurrent.*;

public class Example2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask task = new MyTask();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Future<String> submit = executor.submit(task);
        String valueFromTask = getFutureValue(submit);
        System.out.println(valueFromTask);
        executor.shutdown();
    }

    private static String getFutureValue(Future<String> submit) throws InterruptedException, ExecutionException {
        try {
            return submit.get(1L, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            submit.cancel(true);
            return "default value";
        }
    }

    private static class MyTask implements Callable<String> {

        @Override
        public String call() throws InterruptedException {
            synchronized (Thread.currentThread()) {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Working");
                    Thread.currentThread().wait(300);
//                     break; //uncomment to see this callable returning calculated value
                }
                System.out.println("End of callable working.");
            }

            return "Callable is returning a value";
        }
    }
}



