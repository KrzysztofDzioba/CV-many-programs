package design_patterns.structural.adapter;

public class CelsiusTemperatureProviderImpl implements CelsiusTemperatureProvider {

    private FahrenheitTemperatureProvider bahamasTempProvider;

    CelsiusTemperatureProviderImpl(FahrenheitTemperatureProvider bahamasTempProvider) {
        this.bahamasTempProvider = bahamasTempProvider;
    }

    @Override
    public double getTemperature() {
        double bahamasTemp = bahamasTempProvider.getTemperature();
        double celsius = (bahamasTemp - 32) / 1.8;
        return Math.floor(celsius * 100) / 100;
    }
}
