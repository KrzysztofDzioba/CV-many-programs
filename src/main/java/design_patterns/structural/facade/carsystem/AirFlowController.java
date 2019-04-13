package design_patterns.structural.facade.carsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class AirFlowController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirFlowController.class);
    private AirFlowMeter airFlowMeter = new AirFlowMeter();

    void takeAir() {
        airFlowMeter.getMeasurements();
        LOGGER.info("Air provided!");
    }

    void off() {
        LOGGER.info("Air controller switched off.");
    }
}
