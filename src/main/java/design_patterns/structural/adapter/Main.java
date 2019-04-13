package design_patterns.structural.adapter;

public class Main {

    public static void main(String[] args) {
        FahrenheitTemperatureProvider fahrenheitTemperatureProvider =
                new FahrenheitTemperatureProviderImpl();
        CelsiusTemperatureProvider celsiusTemperatureProvider =
                new CelsiusTemperatureProviderImpl(fahrenheitTemperatureProvider);

        System.out.println(celsiusTemperatureProvider.getTemperature());
    }
}
