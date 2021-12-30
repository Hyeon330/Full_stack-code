import java.util.Scanner;

public class Animal {

    String name;
    static int Weight;

    static Scanner sc = new Scanner(System.in);

    void eatFood() {
        Weight++;
    }

    static void exercise() {
        Weight--;
    }
}
