package design_patterns.structural.facade;

import design_patterns.structural.facade.carsystem.CarEngineFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        CarEngineFacade carEngineFacade = new CarEngineFacade();

        carEngineFacade.startEngine();
        LOGGER.info("bruuuum bruum");
        carEngineFacade.stopEngine();
    }
}
