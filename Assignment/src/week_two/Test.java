package week_two;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate TodayAfter7Days = today.plusDays(7);

        System.out.println(TodayAfter7Days);
    }
}
