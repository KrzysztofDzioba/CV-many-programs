package multithreading.producent.consumer;

class Producent extends Thread {
    private final Bufor buf;
    private final int number;

    public Producent(Bufor c, int number) {
        buf = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            buf.put(i);
            System.out.println("Producent #" +
                    this.number + " put: " + i);
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
