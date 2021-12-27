public class Operator {
    public static void main(String[] agrs) {

        int i = 5;
        System.out.println(i);
        i++;
        System.out.println(i);
        i = i + 1;
        System.out.println(i);
        i--;
        System.out.println(i);
        i = i - 1;
        System.out.println(i);

        System.out.println(i++);
        System.out.println(i);
        System.out.println(++i);
        System.out.println(i);

        i = -10;
        System.out.println(i); // 10
        i = +i;
        System.out.println(i); // -10
        i = -i;
        System.out.println(i); // 10
    }
}
