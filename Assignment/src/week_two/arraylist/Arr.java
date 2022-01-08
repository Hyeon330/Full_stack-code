package week_two.arraylist;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Arr {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        ArrayList<Date> dates = new ArrayList<Date>();

        Date d1 = new Date();
        dates.add(d1);

        cal.add(Calendar.DATE, 1);
        Date d2 = new Date(cal.getTimeInMillis());
        dates.add(d2);

        long randMillis = (long) (Math.random() * 31536000000L);
        Date d3 = new Date(cal.getTimeInMillis() + randMillis);
        dates.add(d3);

        System.out.println(dates);

        for (Date date : dates) {
            DateMillisGap(d1.getTime(), date.getTime());
        }
    }

    static void DateMillisGap(Long nowDate, Long comparisonDate) {
        long dateMillisGap = (long) (comparisonDate - nowDate);

        int randDay = (int) (dateMillisGap / 1000 / 60 / 60 / 24);
        int randDayMillis = randDay * 1000 * 60 * 60 * 24;
        int randHourSec = (int) (dateMillisGap - randDayMillis) / 1000;
        System.out.println(randHourSec);
        LocalTime t = LocalTime.ofSecondOfDay(randHourSec);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
        String hhh = t.format(dtf);

        System.out.println(randDay + "일 " + hhh);
    }
}
