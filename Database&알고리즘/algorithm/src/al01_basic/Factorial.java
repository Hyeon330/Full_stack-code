package al01_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    static int result = 1;

    static void factorialXX(int max) {

        for (int i = 1; i <= max; i++) {
            result *= i;
        }
    }

    static void factorialX(int max) {
        if (max <= 1)
            return;

        result *= max;
        factorial(max - 1);
    }

    public static int factorial(int max) {
        if (max == 1) return max;
        return max *= factorial(max - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.parseInt(bf.readLine());

        System.out.println(factorial(max));
    }
}
