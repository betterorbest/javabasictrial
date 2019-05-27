package cc.better.practice.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {
    private static final Logger LOGGER = LoggerFactory.getLogger(Logging.class);

    public static void main(String[] args) {
        LOGGER.debug("log debug test");
        LOGGER.info("log info test");
        LOGGER.warn("log warn test");
        LOGGER.error("log error test");
    }
}
