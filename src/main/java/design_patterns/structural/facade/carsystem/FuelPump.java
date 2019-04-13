package design_patterns.structural.facade.carsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FuelPump {

    private static final Logger LOGGER = LoggerFactory.getLogger(FuelPump.class);

    void pump() {
        LOGGER.info("Fuel Pump is pumping fuel..");
    }
}
