package week_two.airplane;

import java.util.Calendar;

public abstract class Airplane {

    private Calendar DepartCal;
    private Calendar ArrivalCal;

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

}

class AirplaneSet extends Airplane {

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

}
