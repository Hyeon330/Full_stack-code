import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.time.*;

public class DateAndTime {
    public static void main(String[] args) {
        // Calendar date = Calendar.getInstance();
        // date.set(2016, 2, 7);
        // date.add(Calendar.YEAR, 2);

        // // Calendar cal = Calendar.getInstance();
        // // Date d = new Date(cal.getTimeInMillis());

        // // Date d = new Date();
        // // Calendar cal = Calendar.getInstance();
        // // cal.setTime(d);

        // System.out.println(System.currentTimeMillis());

        // DecimalFormat df = new DecimalFormat("#,###.##");
        // try {
        // Number num = df.parse("1,234,567.89");

        // System.out.println(num.toString());

        // System.out.println(df.format(1234567.89));
        // } catch (ParseException e) {
        // e.printStackTrace();
        // }

        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        // String result = sdf.format(new Date());

        // SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년MM월dd일");
        // try {
        // Date result2 = sdf2.parse("2016년3월8일");
        // System.out.println(result2.toString());
        // System.out.println(sdf2.format(result2));
        // } catch (ParseException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // String pattern = "0#D|60<D|70<C|80<B|90#A";
        // int[] scores = { 51, 99, 80, 88, 70, 52, 60, 1000, -11, -10, -9 };

        // ChoiceFormat cf = new ChoiceFormat(pattern);

        // for (int score : scores) {
        // System.out.println(cf.format(score));
        // }

        // String format = "Name : {0}, Tel : {1}, Loc : {2}";
        // String params[] = { "Clinet.cho", "010.1234.5678", "PanGyo" };

        // MessageFormat messageFormat = new MessageFormat(format);
        // result = messageFormat.format(params);

        // System.out.println(result);

        // System.out.println(String.format("Hello %s", "Java Study"));

        // 9일차 오전 리뷰
        Date d = new Date();
        // Creating a calendar
        Calendar calndr = Calendar.getInstance();

        // Displaying the month
        System.out.println("The Current Month is: "
                + calndr.get(Calendar.MONTH));

        // Replacing with a new value
        calndr.set(Calendar.MONTH, 11);

        // Displaying the modified result
        System.out.println("Altered Month is: "
                + calndr.get(Calendar.MONTH));

        System.out.println("The Current DATE is: "
                + calndr.get(Calendar.DATE));

        calndr.set(Calendar.DATE, 11);

        System.out.println("Altered DATE is: "
                + calndr.get(Calendar.DATE));

        System.out.println("The Current HOUR is: "
                + calndr.get(Calendar.HOUR));

        calndr.set(Calendar.HOUR, 11);

        System.out.println("Altered HOUR is: "
                + calndr.get(Calendar.HOUR));

        System.out.println("The Current MINUTE is: "
                + calndr.get(Calendar.MINUTE));

        calndr.set(Calendar.MINUTE, 11);

        System.out.println("Altered MINUTE is: "
                + calndr.get(Calendar.MINUTE));

        System.out.println("The Current YEAR is: "
                + calndr.get(Calendar.YEAR));

        calndr.set(Calendar.YEAR, 11);

        System.out.println("Altered YEAR is: "
                + calndr.get(Calendar.YEAR));

    }
}
