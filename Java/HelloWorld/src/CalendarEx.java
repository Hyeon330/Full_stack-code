import java.util.*;

class CalendarEx_ {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usang : java CalenderEx yyyy M");
            return;
        }
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);

        Calendar sDay = Calendar.getInstance(); // 시작일
        Calendar eDay = Calendar.getInstance(); // 끝일

        // 월의 경우 0 부터 11까지의 값을 가지므로 1을 빼주어야 한다.
        // 예를 들어, 2015년 11월 1일은 sDay.set(2015, 10, 1); 과 같이 해줘야 한다.
        sDay.set(year, month - 1, 1);
        // 입력월의 말일로 설정한다.
        eDay.set(year, month - 1, sDay.getActualMaximum(Calendar.DATE));
        // 1일이 속한 주의 일요일로 날짜설정.
        sDay.set(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
        // 말일이 속한 주의 토요일로 날짜설정
        eDay.set(Calendar.DATE, 7 - eDay.get(Calendar.DAY_OF_WEEK));

        System.out.println("      " + year + "년 " + month + "월");
        System.out.println(" SU MO TU WE TH FR SA");

        // 시작 일부터 마지막 일까지(sDay <= eDay) 1일씩 증가시키면서 일(Calendar.DATE)을 출력
        for (int n = 1; sDay.before(eDay) || sDay.equals(eDay); sDay.add(Calendar.DATE, 1)) {
            int day = sDay.get(Calendar.DATE);
            System.out.print((day < 10) ? "  " + day : " " + day);
            if (n++ % 7 == 0)
                System.out.println(); // 7일치를 찍고 나서 줄을 바꾼다.
        }
    }
}

public class CalendarEx {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usang : java CalenderEx yyyy M");
            return;
        }
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);

        int START_DAT_OF_WEEK = 0;
        int END_DAY = 0;

        Calendar sDay = Calendar.getInstance(); // 시작일
        Calendar eDay = Calendar.getInstance(); // 끝일

        // 월의 경우 0 부터 11까지의 값을 가지므로 1을 빼주어야 한다.
        // 예를 들어, 2015년 11월 1일은 sDay.set(2015, 10, 1); 과 같이 해줘야 한다.
        sDay.set(year, month - 1, 1);
        eDay.set(year, month, 1);

        // 다음달의 첫날에서 하루를 빼면 현재달의 마지막 날이 된다.
        // 12월 1일에서 하루르 빼면 11월 30일이 된다.
        eDay.add(Calendar.DATE, -1);

        // 첫 번째 요일이 무슨 요일인지 알아낸다.
        START_DAT_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);

        // eDay에 지정된 날짜를 얻어온다.
        END_DAY = eDay.get(Calendar.DATE);

        System.out.println("      " + args[0] + "년 " + args[1] + "월");
        System.out.println(" SU MO TU WE TH FR SA");

        // 해당 월의 1일이 어느 요일인지에 따라서 공백을 출력한다.
        // 만일 1일이 수요일이라면 공백을 세 번 찍는다.(일요일부터 시작)
        for (int i = 1; i < START_DAT_OF_WEEK; i++) {
            System.out.print("   ");
        }

        for (int i = 1, n = START_DAT_OF_WEEK; i <= END_DAY; i++, n++) {
            System.out.print((i < 10) ? "  " + i : " " + i);
            if (n % 7 == 0)
                System.out.println();
        }
    }
}