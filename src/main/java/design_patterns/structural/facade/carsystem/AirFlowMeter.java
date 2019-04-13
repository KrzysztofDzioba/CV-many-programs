package design_patterns.structural.facade.carsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class AirFlowMeter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirFlowMeter.class);

    void getMeasurements() {
        LOGGER.info("Getting air measurements..");
    }
}
