package Demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4jDemo {
    private static Logger logger = LogManager.getLogger(Log4jDemo.class);

    public static void main(String[] args) {
        System.out.println("\n ......Hello World.\n");
        logger.trace("this is trace message ");
        logger.info("this is an information message");
        logger.error("this is error message");
        logger.warn("this is warn message");
        logger.fatal("this is fatal message");

        System.out.println("\n completed");
    }
}
