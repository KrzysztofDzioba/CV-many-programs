package design_patterns.structural.adapter;

import java.util.Random;

public class FahrenheitTemperatureProviderImpl implements FahrenheitTemperatureProvider {

    private static final Random RANDOM = new Random();
    private static final double RANGE_MIN = -459.67;
    private static final double RANGE_MAX = 1000;

    @Override
    public double getTemperature() {
        return RANGE_MIN + (RANGE_MAX - RANGE_MIN) * RANDOM.nextDouble();
    }
}
