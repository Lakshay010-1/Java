package org.program;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jLogger {
    private static  final Logger logger= LogManager.getLogger(Log4jLogger.class);
    public static void process(){
        // Logger Service Method
        logger.trace("Trace Logger Method");
        logger.debug("Debug Logger Method");
        logger.info("Info Logger Method");
        logger.warn("Warn Logger Method");
        logger.error("Error Logger Method");
        logger.fatal("Fatal Logger Method");
    }
    public static void main(String[] args) {
        process();
    }

}
