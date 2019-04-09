package design_patterns.decorator.example1;

public class FirstDecoratorImpl extends Decorator {

    FirstDecoratorImpl(Component componentImpl) {
        super(componentImpl);
    }

    @Override
    public void action() {
        super.action(); // or instead of super.action() invoke method from componentImpl
        additionalMethod();
    }

    private void additionalMethod() {
        System.out.println("This is invoked additional method from " + getClass().getSimpleName());
    }
}
