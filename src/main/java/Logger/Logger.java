package Logger;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    // Variables -
    private final String className;
    private final String threadName;
    // Constructor -
    public Logger(Class currentClass){
        this.className = currentClass.getName();
        this.threadName = Thread.currentThread().getName();
    }

    /**
     * These functions handle info log.
     * @param data - the base data to print.
     * @param moreData - in-case of additional data.
     */
    public void info(String data, Object... moreData){
        printMessage(data, loggerLevels.INFO, moreData);
    }

    /**
     * These functions handle debug log.
     * @param data - the base data to print.
     * @param moreData - in-case of additional data.
     */
    public void debug(String data, Object... moreData){
        printMessage(data, loggerLevels.DEBUG, moreData);
    }

    /**
     * These functions handle warning log.
     * @param data - the base data to print.
     * @param moreData - in-case of additional data.
     */
    public void warning(String data, Object... moreData){
        printMessage(data, loggerLevels.WARNING, moreData);
    }

    /**
     * These functions handle error log.
     * @param data - the base data to print.
     * @param moreData - in-case of additional data.
     */
    public void error(String data, Object... moreData){
        printMessage(data, loggerLevels.ERROR, moreData);
    }

    /**
     * These functions handle server notice log.
     * @param data - the base data to print.
     * @param moreData - in-case of additional data.
     */
    public void serverNotice(String data, Object... moreData){
        printMessage(data, loggerLevels.SERVER_NOTICE, moreData);
    }

    /**
     * These functions handle notice log.
     * @param data - the base data to print.
     * @param moreData - in-case of additional data.
     */
    public void notice(String data, Object... moreData){
        printMessage(data, loggerLevels.NOTICE, moreData);
    }

    /**
     * getting the matching logger color base on the logger level.
     * @param currLvl - the level we need the color for.
     * @return - return the relevant color.
     */
    private  logggerColor getColorByLevel(loggerLevels currLvl){
        switch (currLvl){
            case INFO -> {
                return logggerColor.ANSI_RESET;
            }
            case DEBUG -> {
                return logggerColor.ANSI_GREEN;
            }
            case WARNING -> {
                return logggerColor.ANSI_YELLOW;
            }
            case ERROR -> {
                return logggerColor.ANSI_RED;
            }
            case SERVER_NOTICE -> {
                return logggerColor.ANSI_CYAN;
            }
            case NOTICE -> {
                return logggerColor.ANSI_PURPLE;
            }
        }
        return logggerColor.ANSI_RESET;
    }

    /**
     * This function will print in the console all the needing functions according to the decided format.
     * @param data - data to print.
     * @param currLvl - the logger level that need to print the message.
     * @param moreData - additional data to print.
     */
    private void printMessage(String data, loggerLevels currLvl, Object... moreData){
        // Thread and class String -
        String threadAndClassString = "<" + this.threadName + ">" + " " + "[" + this.className + "]" + ": ";
        // Print the base message -
        System.out.println(getColorByLevel(currLvl) + timeFormatter.defaultTimeFormat() + threadAndClassString + data + logggerColor.ANSI_RESET);
        // Print additional data -
        if(moreData.length != 0){
            for (Object currDataObj : moreData) {
                System.out.println(getColorByLevel(currLvl) + currDataObj.toString() + logggerColor.ANSI_RESET);
            }
        }
    }
}
