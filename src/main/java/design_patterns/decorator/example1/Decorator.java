package design_patterns.decorator.example1;

public abstract class Decorator implements Component {

    Component componentImpl;

    Decorator(Component componentImpl) {
        this.componentImpl = componentImpl;
    }

    @Override
    public void action() {
        componentImpl.action();
    }
}
