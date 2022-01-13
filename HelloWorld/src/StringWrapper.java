public class StringWrapper {
    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = new String("abc");

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        // hash 는 같음 but 연산자 차이가 발생
        System.out.println(c.equals(d));
        System.out.println(c == d);
        // 연산자 차이는 아니고 Wrapper 클래스의 차이가 발생
        System.out.println(a.equals(b));
        System.out.println(a == b);
    }
}
