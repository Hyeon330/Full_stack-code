package thread;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        Function<String, Integer> f = (String s) -> Integer.parseInt(s);
        Function<String, Integer> h = Integer::parseInt;

        System.out.println();

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String shortFormat = formatter.format(LocalDate.of(2000, 1, 1));

        System.out.println(shortFormat);
    }
}