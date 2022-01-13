import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Day8Summary {
    /*
    Calendar
    Date
    DecimalFormat
    SimpleDateFormat
    ChoiceFormat
    MessageFormat
    java.time -> pass
    컬렉션 list, map, set
    arrayList
    */
    public static void main(String[] args) {
        // 싱글턴 패턴, 팩토리 패턴으로 전체 나의 프로그램에서 하나의 객체만 가질 수 있다.
        // Calendar
        Calendar cal = Calendar.getInstance();
        // Date
        Date date = cal.getTime();
        System.out.println(date);

        // SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 hh시mm분ss초");
        System.out.println(sdf.format(date));

        // DecimalFormat
        DecimalFormat df = new DecimalFormat("0");
        System.out.println(df.format(12345.6789));

        df = new DecimalFormat("00000,00.0000000");
        System.out.println(df.format(12345.6789));

        // ChoiceFormat
        int[] point = {61,60,50,80,50,60,70,60,75,65,0};
        String patten = "0#불합격|60<합격";
        ChoiceFormat cf = new ChoiceFormat(patten);

        for (int i = 0; i < point.length; i++) {
            System.out.println(i + 1 + "번" + ":" + cf.format(point[i]));
        }

        // MessageFormat
        patten = "First : {0} \nSecond : {1} \nThird : {2} \nFourth : {3}";
        Object[] arguments = {"가나다", "ABC", "123", "!@#"};
        String result = MessageFormat.format(patten, arguments);
        System.out.println(result);

        // ArrayList
        ArrayList list = new ArrayList();
        list.add("test1");
        list.add("test3");
        list.add("test5");
        list.add("test7");

        System.out.println(list);
        System.out.println(list.get(3));
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());

        ArrayList list2 = new ArrayList();
        list2.add("list1");
        list2.add("list11");

        list.addAll(list2);

        System.out.println(list);
    }
}
