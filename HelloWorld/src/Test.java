import java.util.StringJoiner;

public class Test {

}

class StringBufferEx {
    public static void main(String[] agrs) {
        StringBuffer sb1 = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");

        System.out.println("sb1 == sb2 ? " + (sb1 == sb2));
        System.out.println("sb1.equals(sb2) ? " + sb1.equals(sb2));

        // StringBuffer의 내용을 String으로 변환한다.
        String s1 = sb1.toString();
        String s2 = sb2.toString();

        System.out.println("s1.equals(s2)" + s1.equals(s2));
    }
}