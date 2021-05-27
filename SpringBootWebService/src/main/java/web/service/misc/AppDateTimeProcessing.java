package web.service.misc;

import java.time.LocalDateTime;

public class AppDateTimeProcessing {

    private String dateTimeTwoDigit(int param) {
        String value = String.valueOf(param);
        value = value.length() < 2? "0" + value:value;
        return value;
    }

    public String getDateTimeString() {
        String year = String.valueOf(LocalDateTime.now().getYear());
        String month = dateTimeTwoDigit(LocalDateTime.now().getMonthValue());
        String day = dateTimeTwoDigit(LocalDateTime.now().getDayOfMonth());
        String hour = dateTimeTwoDigit(LocalDateTime.now().getHour());
        String minute = dateTimeTwoDigit(LocalDateTime.now().getMinute());
        String second = dateTimeTwoDigit(LocalDateTime.now().getSecond());

        return year + month + day + hour + minute + second;
    }
}
