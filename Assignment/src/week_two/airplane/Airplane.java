package week_two.airplane;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Airplane {

    private Calendar DepartCal; // 출발 날짜
    private Calendar ArrivalCal; // 도착 날짜
    private String isDomestic;

    public Calendar getDepartCal() {
        return this.DepartCal;
    }

    public void setDepartCal(Calendar DepartCal) {
        this.DepartCal = DepartCal;
    }

    public Calendar getArrivalCal() {
        return this.ArrivalCal;
    }

    public void setArrivalCal(Calendar ArrivalCal) {
        this.ArrivalCal = ArrivalCal;
    }

    public void OutputDepartDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        System.out.println(sdf.format(getDepartCal().getTime()));
    }

    public void OutputArrivalDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        System.out.println(sdf.format(getArrivalCal().getTime()));
    }

    public String getIsDomestic() {
        return isDomestic;
    }

    public void setIsDomestic(String isDomestic) {
        this.isDomestic = isDomestic;
    }

    abstract void Domestic(String Domestic);

    abstract void Overseas(String Overseas);

    abstract String flight(String Domestic);

}