package cc.better.practice.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {
    private static final Logger LOGGER = LoggerFactory.getLogger(Logging.class);

    public static void main(String[] args) {
        LOGGER.info("log test");
    }
}
