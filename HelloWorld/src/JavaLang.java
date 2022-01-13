import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaLang {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        if (v1.equals(v2)) {
            System.out.println("같은 객체");
        } else {
            System.out.println("다른 객체");
        }

        v2 = v1;

        if (v1.equals(v2)) {
            System.out.println("같은 객체");
        } else {
            System.out.println("다른 객체");
        }
    }
}

class Value {
    int value;

    Value(int value) {
        this.value = value;
    }
}

// class Person {
//     long id;

//     Person(long id) {
//         this.id = id;
//     }

//     public boolean equals(Object obj) {
//         if (obj != null && obj instanceof Person) {
//             return id == ((Person) obj).id;
//         } else {
//             return false;
//         }
//     }
// }

// class EqualsEx2 {
//     public static void main(String[] args) {
//         Person p1 = new Person(8602192222111L);
//         Person p2 = new Person(8602192222111L);

//         if (p1 == p2) {
//             System.out.println("같은 객체");
//         } else {
//             System.out.println("다른 객체");
//         }

//         if (p1.equals(p2)) {
//             System.out.println("같은 값");
//         } else {
//             System.out.println("다른 값");
//         }
//     }
// }

class HashCodeEx1 {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = new String("abc");

        str2.toString();

        System.out.println(str1.equals(str2));

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode(str2));
    }
}

// class Card {
//     String kind;
//     int number;

//     Card() {
//         this("SPADE", 1);
//     }

//     Card(String kind, int number) {
//         this.kind = kind;
//         this.number = number;
//     }

//     public String toString() {
//         return "kind : " + kind + ", number : " + number;
//     }

//     @Override
//     public Card clone() {
//         try {
//             return (Card) super.clone();
//         } catch (Exception e) {
//             return null;
//         }
        
//     }
// }

class CardToString {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();
        // Card c3 = c2.clone();

        System.out.println(c1.toString());
        System.out.println(c2.toString());
        // System.out.println(c3.toString());

        int[] arr = {1, 2, 3, 4, 5};
        int[] arrClone = arr.clone();

        for (int i = 0; i < arrClone.length; i++) {
            System.out.println(arrClone[i]);
        }

        Card card = new Card();
        Class c0bj = card.getClass();

        c0bj = Card.class;
        try {
            c0bj = Class.forName("Card");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String animals = "dog,cat,bear";
        String[] arr2 = animals.split(",");
        String str = String.join("-", arr2);
        System.out.println(str);

        StringJoiner sj = new StringJoiner(",","[","]");
        String[] strArr = {"aaa", "bbb", "ccc"};
        for (String string : strArr) {
            sj.add(string.toUpperCase());
        }
        System.out.println(sj.toString());

        try {
            byte[] utf8_str = "가".getBytes("UTF-8");
            String str2 = new String(utf8_str, "UTF-8");

            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String str3 = String.format("%d 더하기 %d는 %d입니다.", 3, 5, 3 + 5);
        System.out.println(str3);

        int i = 100;
        String str1 = i + "";
        String str2 = String.valueOf(i); // 이거 성능은 더 좋음
        System.out.println(str1);
        System.out.println(str2);

        String str5 = "    d     d     ";
        System.out.println("[" + str5 + "]");
        System.out.println("[" + str5.trim() + "]");

        System.out.println("[" + str5.substring(6) + "]"); // [    d     ]
        System.out.println("[" + str5.substring(4, 7) + "]");

        String str6 = "Hello.java";
        int index = str6.indexOf('.');
        int index2 = str6.lastIndexOf('.');
        String a = str6.substring(0, 5);
        String b = str6.substring(index2 + 1, 10);

        System.out.println(index);
        System.out.println(index2);
        System.out.println(a);
        System.out.println(b);

        // StringBuffer 생성자는 이미 구현되어 있는 것이라 패스

        char[] value = new char[16];

        value[0] = '1';
        value[4] = '1';
        
        int newCapacity = 16;
        char newValue[] = new char[newCapacity];

        System.arraycopy(value, 0, newValue, 0, 10);
        value = newValue;

        System.out.println(value);
        System.out.println(newValue);

        StringBuffer sb = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");
        System.out.println(sb == sb2);
        System.out.println(sb.equals(sb2));

        String s = sb.toString();
        String s2 = sb2.toString();

        System.out.println(s.equals(s2));

        System.out.println(Math.E);
        System.out.println(Math.PI);
        System.out.println(Math.min(1, 2));
        System.out.println(Math.max(1, 2));
        System.out.println(Math.abs(-2));
        System.out.println(Math.sqrt(4));
        System.out.println(Math.pow(2, 10));
        System.out.println(Math.ceil(23.23));
        System.out.println(Math.floor(23.23));
        System.out.println(Math.round(23.23));
        System.out.println(Math.addExact(200, 11111111));
        System.out.println(200 + 11111111);
        System.out.println(Math.incrementExact(123123123));
        System.out.println(Math.negateExact(-123123));
        // System.out.println(Math.toIntExact(1123123123123123L));
        System.out.println((int) 1123123123123123L);

        boolean b2 = false;
        Boolean b3 = new Boolean("true");

        System.out.println(b2);
        System.out.println(b3==true);

        char ch2 = new Character('d');
        Integer int2 = 3;

        System.out.println(ch2);
        System.out.println(int2);

        BigInteger bi = new BigInteger("12345678901234567890123456789012345", 35);
        System.out.println(bi);

        int i3 = new Integer("10").intValue();
        int i4 = Integer.parseInt("100");
        Integer i5 = Integer.valueOf("100");

        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);

        System.out.println(Integer.parseInt("100", 2));
        System.out.println(Integer.parseInt("100", 8));
        System.out.println(Integer.parseInt("FFF", 16));
        System.out.println(Integer.parseInt("100", 2));

        System.out.println(Integer.valueOf("100", 2));
        System.out.println(Integer.valueOf("100", 8));
        System.out.println(Integer.valueOf("FFF", 16));
        System.out.println(Integer.valueOf("100", 2));

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        int value5 = list.get(0);
        System.out.println(value5);

        Random r = new Random();
        System.out.println(r.nextInt());

        System.out.println(Objects.nonNull(r));
    }
}

class RegularEx1 {
    public static void main(String[] args) {
        String[] data = {"bat", "baby", "bonus", "cA"};
        Pattern p = Pattern.compile("c[a-zA-Z]*");
        for (int i = 0; i < data.length; i++) {
            Matcher m = p.matcher(data[i]);
            if(m.matches())
                System.out.print(data[i] + ",");
        }
    }
}

class StringTokenizerEx1 {
    public static void main(String[] args) {
        String sources = "10,200,300,400";
        StringTokenizer st = new StringTokenizer(sources, ",");
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        BigDecimal val;
        val = new BigDecimal("123.4567890");

        System.out.println(val.intValue());
        System.out.println(val.longValue());
        System.out.println(val.precision());
    }
}