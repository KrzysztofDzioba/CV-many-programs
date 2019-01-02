package design_patterns.observator;

public class Listener2 implements Listener {
    @Override
    public void doAfterListening() {
        System.out.println("Listener2 is listening!");
    }
}
