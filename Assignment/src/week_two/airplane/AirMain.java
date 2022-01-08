package week_two.airplane;

import java.util.Calendar;

public class AirMain {
    public static void main(String[] args) {
        Calendar calD = Calendar.getInstance();
        Calendar calA = Calendar.getInstance();
        AirplaneChild airSet = new AirplaneChild();

        calD.set(2022, 1, 1);
        calA.set(2022, 1, 2);

        airSet.setDepartCal(calD);
        airSet.setDepartCal(calA);

        airSet.OutputDepartDate();
    }
}
