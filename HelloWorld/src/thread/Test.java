package thread;

import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        Function<String, Integer> f = (String s) -> Integer.parseInt(s);
        Function<String, Integer> h = Integer::parseInt;

        System.out.println(h.apply("3"));

    }
}
