package Day_5_assign.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Today {
    public static void main(String[] args) {
        Date today = new Date();

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println(date.format(today));
    }
}