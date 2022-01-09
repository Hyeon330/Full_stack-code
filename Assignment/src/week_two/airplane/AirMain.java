package week_two.airplane;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

import week_two.human.Human;

public class AirMain {
    public static void main(String[] args) {
        // ------------------------- 과제 4, 5 ---------------------------------
        Calendar calD = Calendar.getInstance();
        Calendar calA = Calendar.getInstance();
        AirplaneChild airplaneChild = new AirplaneChild();

        calD.set(2022, 1, 1);
        calA.set(2022, 1, 2);

        airplaneChild.setDepartCal(calD);
        airplaneChild.setArrivalCal(calA);

        airplaneChild.OutputDepartDate();
        airplaneChild.OutputArrivalDate();

        // -------------------------아래부터 10번 과제------------------------------
        Scanner sc = new Scanner(System.in);

        LocalDate today = LocalDate.now();
        LocalDate TodayAfter7Days = today.plusDays(7);

        LocalDate Departuredate = null;
        LocalDate Arrivaldate = null;
        ArrayList<LocalDate> DepartureDates = new ArrayList<LocalDate>(); // 출발 날짜
        ArrayList<LocalDate> ArrivalDates = new ArrayList<LocalDate>(); // 도착 날짜

        final int DepartureDateNum = 5;
        int count = 0;
        System.out.println("출발날짜를 5개 입력해 주세요.");
        for (int i = 0; i < DepartureDateNum; i++) {
            count++;
            while (true) {
                System.out.print(count + "번째 ");
                System.out.print("출발 날짜 입력(yyyy-MM-dd) : ");

                // String DepartureStr = sc.nextLine(); // 직접입력할 시 입력

                // -------- 랜덤값 입력시 ----------
                Departuredate = today.plusDays((int) (Math.random() * 7));
                System.out.println(Departuredate);
                // --------------------------------

                try {
                    // Departuredate = LocalDate.parse(DepartureStr); // 직접 입력할시 예외 처리
                    Arrivaldate = Departuredate.plusDays(1);

                    if (DepartureDates.contains(Departuredate)) {
                        System.out.println("중복된 값이 있습니다.");
                    } else if (Departuredate.getDayOfMonth() > TodayAfter7Days.getDayOfMonth()) {
                        System.out.println("7일 이내로 입력해 주세요.");
                    } else {
                        break;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("날짜를 정확히 확인 후 yyyy(년)-MM(월)-dd(일) 형식으로 입력해 주세요.");
                }
                System.out.println();
            }
            DepartureDates.add(Departuredate);
            ArrivalDates.add(Arrivaldate);
        }
        System.out.println(DepartureDates);
        System.out.println(ArrivalDates);

        // -------------------- 무작위로 speed와 국내선, 국제선 중 1개 세팅------------------

        ArrayList<Human> humans = new ArrayList<Human>(Arrays.asList(new Human(), new Human(), new Human()));
        int randDomesticAndOverseas = 0;
        String randAirplane;
        ArrayList<String> DomesticAndOverseasList = new ArrayList<String>();

        for (Human human : humans) {
            randDomesticAndOverseas = (int) (Math.random() * 2);
            DomesticAndOverseasList = human.getAirplane().getDomesticAndOverseas().get(randDomesticAndOverseas);
            randAirplane = DomesticAndOverseasList.get((int) (Math.random() * DomesticAndOverseasList.size()));

            human.setSpeed(((int) (Math.random() * 7)) + 1);

            System.out.println(human.getAirplane().flight(randAirplane));
        }

        sc.close();
    }
}
