package util;

import java.util.Arrays;
import java.util.StringJoiner;

public class JavaLang {

}

class Person {
    long id;

    Person(long id) {
        this.id = id;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Person) {
            return id == ((Person) obj).id;
        } else {
            return false;
        }
    }
}

class EqualsEx2 {
    public static void main(String[] args) {
        Person p1 = new Person(8602192222111L);
        Person p2 = new Person(8602192222111L);

        if (p1 == p2) {
            System.out.println("eqauls == true");
        } else {
            System.out.println("eqauls == false"); // 서로다른 주소 참조
        }

        if (p1.equals(p2)) {
            System.out.println("eqauls == true"); // 서로 같은 값
        } else {
            System.out.println("eqauls == false");
        }
    }
}

class HashCodeEx1 {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");

        str2.toString();

        System.out.println(str1.equals(str2)); // true

        System.out.println(str1.hashCode()); // 96354
        System.out.println(str2.hashCode()); // 96354

        System.out.println(System.identityHashCode(str1)); // 27134973
        System.out.println(System.identityHashCode(str2)); // 1284693
    }
}

class Card {
    String kind;
    int number;

    Card() {
        this("SPADE", 1);
    }

    Card(String kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    // 조상클래스(Object)에 정의된 접근범위보다 같거나 넓어야 하므로, public
    public String toString() {
        return "kind : " + kind + ", number : " + number;
    }

    public Card clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return (Card) obj;
    }
}

class CardToString {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();
        Card c3 = c2.clone();

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        // System.out.println(c3.toString());

        int[] arry = { 1, 2, 3, 4, 5 };

        // int[] arrClone = new int[arr.length];
        // System.arraycopy(arr,0,arrClone,0,arr.length);
        int[] arrClone = arry.clone();
        System.out.println(Arrays.toString(arrClone));

        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");
        String str = String.join("-", arr);
        System.out.println(str); // dog-cat-bear

        StringJoiner sj = new StringJoiner(",", "[", "]");
        String[] strArr = { "aaa", "bbb", "ccc" };
        for (String s : strArr)
            sj.add(s.toUpperCase());
        System.out.println(sj.toString()); // [AAA,BBB,CCC]
    }
}
