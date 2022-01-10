package week_two.airplane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class AirplaneChild extends Airplane {
    private ArrayList<String> domesticArr = new ArrayList<String>(Arrays.asList("김포", "인천", "김해", "제주", "울산"));
    private ArrayList<String> overseasArr = new ArrayList<String>(Arrays.asList("도쿄", "상하이", "홍콩", "싱가폴", "쿠알라룸푸르"));
    private ArrayList<ArrayList<String>> DomesticAndOverseas = new ArrayList<ArrayList<String>>(
            Arrays.asList(domesticArr, overseasArr));

    public ArrayList<ArrayList<String>> getDomesticAndOverseas() {
        return DomesticAndOverseas;
    }

    @Override
    public void setDepartCal(Calendar DepartCal) {
        super.setDepartCal(DepartCal);
    }

    @Override
    public void setArrivalCal(Calendar ArrivalCal) {
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
    String flight(String DepartCal) {
        if (this.domesticArr.contains(DepartCal)) {
            setIsDomestic("국내선");
        } else if (this.overseasArr.contains(DepartCal)) {
            setIsDomestic("국외선");
        }
        return this.getIsDomestic();
    }

}
