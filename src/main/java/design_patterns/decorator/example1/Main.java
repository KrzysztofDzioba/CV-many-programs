package design_patterns.decorator.example1;

public class Main {

    public static void main(String[] args) {
        Component componentImpl = () -> System.out.println("ComponentImpl is doing an action");
        Decorator firstDecoratorImpl = new FirstDecoratorImpl(componentImpl);
        Decorator secondDecorator = new SecondDecoratorImpl(firstDecoratorImpl);
        secondDecorator.action();
//        firstDecoratorImpl.action();
    }
}
