package design_patterns.structural.facade.carsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class CatalyticConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalyticConverter.class);

    void on() {
        LOGGER.info("Catalytic Converter switched on!");
    }

    void off() {
        LOGGER.info("Catalytic Converter switched off!");
    }
}
