package multithreading.producent.consumer;

class Bufor {
    private int contents;
    private boolean available = false;

    synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return contents;
    }

    synchronized void put(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        contents = value;
        available = true;
        notifyAll();
    }
}