package design_patterns.structural.facade.carsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FuelInjector {
    private static final Logger LOGGER = LoggerFactory.getLogger(FuelInjector.class);

    private FuelPump fuelPump = new FuelPump();

    void on(){
        LOGGER.info("Fuel injector ready to inject fuel.");
    }

    void inject() {
        fuelPump.pump();
        LOGGER.info("Fuel injected.");
    }

    void off() {
        LOGGER.info("Stopping Fuel injector..");
    }
}
