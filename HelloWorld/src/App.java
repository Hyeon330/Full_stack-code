import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        int score = 100;
        System.out.println(score);
        score = 200;
        System.out.println(score);
        char ch = 'A';
        System.out.println(ch);
        String str = "abc";
        System.out.println(str);

        long haha = 2313123L;
        System.out.println(haha);

        ch = 'A';
        System.out.println(ch);

        System.out.println(10); // Dec
        System.out.println(010); // Oct to Dec
        System.out.println(0x10); // Hex to Dec
        System.out.println(Integer.toBinaryString(10)); // Dec to Bin
        System.out.println(Integer.toOctalString(8)); // Dec to Oct
        System.out.println(Integer.toHexString(16)); // Dec to Hex
        System.out.println(Integer.toString(10) + 20); // int to String
        System.out.println(Integer.parseInt("10") + 20); // String to int

        System.out.printf("%5d \n", 10);

        long lala = 20000000000L;
        System.out.println(lala);

        Scanner scan = new Scanner(System.in);
        String aaa = scan.nextLine();
        System.out.println(aaa);
    }
}
