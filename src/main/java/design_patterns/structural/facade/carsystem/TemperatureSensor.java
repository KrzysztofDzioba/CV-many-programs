package design_patterns.structural.facade.carsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TemperatureSensor {
    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureSensor.class);

    void getTemperature(){
        LOGGER.info("Getting temperature from the sensor..");
    }

}