package week_two.arraylist;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Arr {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        ArrayList<Date> dates = new ArrayList<Date>();

        Date d1 = new Date(); // 현재 날짜
        dates.add(d1);

        cal.add(Calendar.DATE, 1);
        Date d2 = new Date(cal.getTimeInMillis()); // 내일 날짜
        dates.add(d2);

        long randMillis = (long) (Math.random() * 31536000000L);
        Date d3 = new Date(cal.getTimeInMillis() + randMillis); // 1년 이내 랜덤 날짜
        dates.add(d3);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd");

        int count = 0;
        for (Date date : dates) { // 날짜들 출력
            count++;
            System.out.print(count + "번 날짜 : " + sdf.format(date) + "       ");
        }

        System.out.println();
        System.out.println();

        PrintGapDate(dates, d1, d2); // 현재날짜와 차이 출력
    }

    static void DateMillisGap(Long nowDate, Long comparisonDate) {
        long dateMillisGap = (long) (comparisonDate - nowDate);

        int randDay = (int) (dateMillisGap / 1000 / 60 / 60 / 24);
        int randDayMillis = randDay * 1000 * 60 * 60 * 24;
        int randHourSec = (int) (dateMillisGap - randDayMillis) / 1000;
        LocalTime t = LocalTime.ofSecondOfDay(randHourSec);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
        String hhh = t.format(dtf);

        System.out.println("현재 날짜와 " + randDay + "일 " + hhh + " 차이");
    }

    static void PrintGapDate(ArrayList<Date> dates, Date d1, Date d2) {
        int count = 0;
        for (Date date : dates) {
            count++;
            System.out.print(count + "번 날짜 : ");
            DateMillisGap(d1.getTime(), date.getTime());
        }
    }
}
