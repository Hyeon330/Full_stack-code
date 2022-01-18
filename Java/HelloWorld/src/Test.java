import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.Arrays;
import java.util.Objects;

public class Test {

}

class ObjectTest {
    public static void main(String[] args) {
        String[][] str2D = new String[][] { { "aaa", "bbb" }, { "AAA", "BBB" } };
        String[][] str2D_2 = new String[][] { { "aaa", "bbb" }, { "AAA", "BBB" } };

        System.out.print("strD = {");
        for (String[] tmp : str2D) {
            System.out.print(Arrays.toString(tmp));
        }
        System.out.println("}");

        System.out.print("strD_2 = {");
        for (String[] tmp : str2D_2) {
            System.out.print(Arrays.toString(tmp));
        }
        System.out.println("}");

        System.out.println("equals(str2D, str2D_2)=" + Objects.equals(str2D, str2D_2));
        System.out.println("deepEquals(str2D, str2D_2)=" + Objects.deepEquals(str2D, str2D_2));

        System.out.println("isNull(null) =" + isNull(null));
        System.out.println("nonNull(null) =" + nonNull(null));
        System.out.println("hashCode(null) =" + Objects.hashCode(null));
        System.out.println("toString(null) = " + Objects.toString(null));
        System.out.println("toString(null, \"\") =" + Objects.toString(null, ""));
    }
}