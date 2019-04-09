package design_patterns.decorator.example1;

public class SecondDecoratorImpl extends Decorator {

    SecondDecoratorImpl(Component componentImpl) {
        super(componentImpl);
    }

    @Override
    public void action() {
        super.action();
        additionalMethod();
    }

    private void additionalMethod() {
        System.out.println("This is additional method in " + getClass().getSimpleName());
    }
}
