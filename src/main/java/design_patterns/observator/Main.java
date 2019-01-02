package design_patterns.observator;

class Main {

    public static void main(String[] args) {
        Speaker speaker = new Speaker();

        Listener listener1 = new Listener1();
        Listener listener2 = new Listener2();
        speaker.addListener(listener1);
        speaker.addListener(listener2);

        speaker.speak();
    }
}
