package design_patterns.observator;

public class Listener1 implements Listener {

    @Override
    public void doAfterListening() {
        System.out.println("Listener1 is listening!");
    }
}
