package design_patterns.observator;

class Speaker {

    private final Listeners listeners = new Listeners();

    void addListener(Listener listener) {
        listeners.addListener(listener);
    }

    void speak() {
        System.out.println("Speaker is speaking");
        listeners.notifyListeners();
    }

}
