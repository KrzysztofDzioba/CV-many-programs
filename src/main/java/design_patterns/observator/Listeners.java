package design_patterns.observator;

import java.util.ArrayList;
import java.util.List;

class Listeners {

    private final List<Listener> listeners = new ArrayList<>();

    void addListener(Listener listener) {
        listeners.add(listener);
    }

    void notifyListeners() {
        listeners.forEach(Listener::doAfterListening);
    }
}
