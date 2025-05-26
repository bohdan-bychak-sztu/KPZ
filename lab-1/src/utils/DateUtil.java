package utils;

import java.time.LocalDate;

public class DateUtil {
    public static String getTodayDate() {
        return LocalDate.now().toString();
    }
}
