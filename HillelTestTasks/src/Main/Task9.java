package Main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Task9 {

    public static String getDate(String date){
        if(date.charAt(2)!='.'||date.charAt(5)!='.'){
            return "Wrong format of date";
        }
        if(date.charAt(date.length()-3)!=':'||date.charAt(date.length()-6)!=':'||date.charAt(10)!=' '){
            return "Time in wrong format";
        }
        date = date.replace('.', '/');
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        formatter = DateTimeFormatter.ofPattern("dd, MMM hh:mm a", Locale.ENGLISH);
        return dateTime.format(formatter);
    }
}
