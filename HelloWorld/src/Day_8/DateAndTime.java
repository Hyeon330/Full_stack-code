package Day_8;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTime {
    public static void main(String[] args) {
        // Calendar date = Calendar.getInstance();
        // date.set(2016, 2, 7);
        // date.add(Calendar.YEAR, 2);

        // Calendar cal = Calendar.getInstance()
        // Date d = new Date(cal.getTimeInMillis());

        // Date d = new Date();
        // Calendar cal = Calendar.getInstance();
        // cal.setTime(d);

        System.out.println(System.currentTimeMillis()); // 그레고리력 1970년 부터 1초단위로 찍어줌

        // js code
        // var date = new Date(System.currentTimeMillis());

        // date.toString("MMM dd"):

        // DecimalFormat df = new DecimalFormat("#, ###.##");
        // try {
        // Number num = df.parse("1,234,567.89");
        // System.out.println(num.toString());

        // System.out.println(df.format(1234567.89));
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        // String result = sdf.format(new Date());

        // SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy년MM월dd일");
        // try {
        // Date result2 = sdf2.parse("2016년3월8일");
        // System.out.println(result2.toString());
        // sdf2.format(sdf2.format(result2));
        // } catch (Exception e) {
        // //TODO: handle exception
        // e.printStackTrace();
        // }

        // String pattern = "60#D|70#C|80<B|90#A";
        // int[] scores = {91, 90, 80, 88, 70, 52, 60, -1, -32, 132};

        // ChoiceFormat cf = new ChoiceFormat(pattern);

        // for(int score : scores) {
        // System.out.println(cf.format(score));
        // }

        // String format = "Name : {0}, Tel : {1}, Loc : {2}";
        // String[] params = {"Clint.cho", "010.1234.5678", "PanGyo"};

        // MessageFormat messageFormat = new MessageFormat(format);
        // String result = messageFormat.format(params);

        // System.out.println(String.format("hello %s", "Java Study"));
        // System.out.println(result);

        // 리뷰
        // Calender
        // Calendar cal1 = Calendar.getInstance(); // getInstance()로 객체 생성
        // Calendar cal2 = Calendar.getInstance();

        // cal2.set(2021, 9, 20);

        // System.out.println(((cal1.getTimeInMillis() - cal2.getTimeInMillis()) / 1000)
        // / (60 * 60 * 24));

        // // date
        // Date date = cal.getTime();
        // System.out.println(date);

        // // SimpleDateFormat
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 hh시mm분ss초");
        // System.out.println(sdf.format(date));

        // DecimalFormat
        // DecimalFormat df = new DecimalFormat("0");
        // System.out.println(df.format(12345.6789));

        // df = new DecimalFormat("0,00.000");
        // System.out.println(df.format(12345.6789));

        // // ChoiceFormat
        // int[] point = { 61, 60, 50, 80, 60, 60, 70, };
        // String patten = "0#불합격|60<합격";
        // ChoiceFormat cf = new ChoiceFormat(patten);
        // for (int i = 0; i < point.length; i++) {
        // System.out.println(i + 1 + "번" + ":" + cf.format(point[i]));
        // }

        // MessageFormat
        // String patten = "First : {0} \nSecond : {1} \nThird : {2} \nFouth : {3}";
        // Object[] arguments = { "가나다", "ABC", "123", "!@#" };
        // String result = MessageFormat.format(patten, arguments);
        // System.out.println(result);

        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS a E요일");
        System.out.println(sdf.format(today));

    }
}
