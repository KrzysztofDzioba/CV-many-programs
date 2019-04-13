package design_patterns.structural.facade.carsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Radiator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Radiator.class);

    void on(){
        LOGGER.info("Radiator switched on!");
    }

    void off(){
        LOGGER.info("Radiator switched off!");
    }

    void setSpeed(Integer speed){
        LOGGER.info("Setting radiator speed to {}",speed);
    }
}
