package multithreading.producent.consumer;

class ProducentConsumentTest {
    public static void main(String[] args) {
        Bufor c = new Bufor();
        Producent p1 = new Producent(c, 1);
        Consument c1 = new Consument(c, 1);
        p1.start();
        c1.start();
    }
}
