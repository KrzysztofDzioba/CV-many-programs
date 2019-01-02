package multithreading.producent.consumer;

class Consument extends Thread {
    private final Bufor buf;
    private final int number;

    public Consument(Bufor c, int number) {
        buf = c;
        this.number = number;
    }

    public void run() {
        int value;
        for (int i = 0; i < 10; i++) {
            value = buf.get();
            System.out.println("Consument #" + this.number + " got: " + value);
        }
    }
}
