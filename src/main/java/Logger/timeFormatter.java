package Logger;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class timeFormatter {
    public static String defaultTimeFormat(){
        //Create formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy, hh:mm:ss ");
        //Local date instance
        ZonedDateTime currentTime = ZonedDateTime.now();
        //Get formatted String
        return formatter.format(currentTime);
    }
}
