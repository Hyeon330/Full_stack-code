package week_two.airplane;

import java.util.Calendar;

public class AirMain {
    public static void main(String[] args) {
        Calendar calD = Calendar.getInstance();
        Calendar calA = Calendar.getInstance();
        AirplaneSet airSet = new AirplaneSet();

        calD.set(2022, 1, 1);
        calA.set(2022, 1, 2);

        airSet.setDepartCal(calD);
        airSet.setDepartCal(calA);
    }
}
