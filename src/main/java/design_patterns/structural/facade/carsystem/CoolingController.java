package design_patterns.structural.facade.carsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CoolingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CoolingController.class);
    private static final Integer DEFAULT_RADIATOR_SPEED = 10;

    private Integer temperatureUpperLimit;
    private Radiator radiator = new Radiator();
    private TemperatureSensor temperatureSensor = new TemperatureSensor();

    void setTemperatureUpperLimit(Integer temperatureUpperLimit) {
        LOGGER.info("Setting temperature upper limit to {}", temperatureUpperLimit);
        this.temperatureUpperLimit = temperatureUpperLimit;
    }

    void run() {
        LOGGER.info("Cooling Controller ready!");
        radiator.setSpeed(DEFAULT_RADIATOR_SPEED);
    }

    void cool(Integer maxAllowedTemp) {
        LOGGER.info("Scheduled cooling with maximum allowed temperature {}", maxAllowedTemp);
        temperatureSensor.getTemperature();
        radiator.on();
    }

    void stop() {
        LOGGER.info("Stopping Cooling Controller..");
        radiator.off();
    }
}
