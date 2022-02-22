import Logger.Logger;

public class test {
    // add private methods or vars.

    public static void main(String[] args){
        Logger logger = new Logger(test.class);
        String test = "TESTING??";
        logger.info("this is info",test);
        logger.warning("this is warning");
        logger.error("this is error");
        logger.debug("this is debug");
        logger.serverNotice("this is serverNotice");
        logger.notice("this is notice");
    }
}
