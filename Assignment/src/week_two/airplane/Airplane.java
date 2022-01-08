package week_two.airplane;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public abstract class Airplane {

    private Calendar DepartCal;
    private Calendar ArrivalCal;
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

    abstract void Domestic(String Domestic);

    abstract void Overseas(String Overseas);

    abstract String flight(String Domestic);

}

class AirplaneChild extends Airplane {
    private ArrayList<String> domesticArr = new ArrayList<String>(Arrays.asList("김포", "인천", "김해", "제주", "울산"));
    private ArrayList<String> overseasArr = new ArrayList<String>(Arrays.asList("도쿄", "상하이", "홍콩", "싱가폴", "쿠알라룸푸르"));

    @Override
    public void setDepartCal(Calendar DepartCal) {
        DepartCal = Calendar.getInstance();
        super.setDepartCal(DepartCal);
    }

    @Override
    public void setArrivalCal(Calendar ArrivalCal) {
        ArrivalCal = Calendar.getInstance();
        super.setArrivalCal(ArrivalCal);
    }

    @Override
    void Domestic(String Domestic) {
        this.domesticArr.add(Domestic);
    }

    @Override
    void Overseas(String Overseas) {
        this.overseasArr.add(Overseas);
    }

    ArrayList<String> Domestic() {
        return domesticArr;
    }

    ArrayList<String> Overseas() {
        return overseasArr;
    }

    @Override
    String flight(String Domestic) {
        Domestic();
        return null;
    }

}
