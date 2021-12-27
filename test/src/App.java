import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        byte bt = scan.nextByte();
        System.out.println(bt);

        scan.close();
    }
}
