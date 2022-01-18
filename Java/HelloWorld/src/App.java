import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // int score = 100;
        // System.out.println(score);
        // score = 200;
        // System.out.println(score);
        // char ch = 'A';
        // System.out.println(ch);
        // String str = "abc";
        // System.out.println(str);
        // final int MAX = 100;
        // System.out.println(MAX);
        // 5분 실습 41분까지
        boolean power = true;
        System.out.println(power);
        char ch = 'A'; // 앞에서 ch 라는 변수를 선언했기때문에 에러 발생함
        System.out.println(ch);
        ch = '\u0041'; // 앞에서 선언한 ch 는 변수이므로 그냥 인가만 해주면 된다.
        System.out.println(ch);
        char tab = '\t';
        System.out.println(tab + "탭");
        byte b = 127;
        System.out.println(b);
        short s = 32767;
        System.out.println(s);
        int i = 100;
        System.out.println(i);
        int oct = 0100;
        System.out.println(oct);
        int hex = 0x100;
        System.out.println(hex);
        long l = 10000000000L;
        System.out.println(l);
        float f = 3.14f;
        System.out.println(f);
        double d = 3.14d;
        System.out.println(d);
        f = 100f;
        System.out.println(f);
        boolean bool = false;
        System.out.println(bool);
        int int2 = 0;
        System.out.println(int2);

        // 문자와 문자열 실습 48분까지
        ch = 'A'; // 에러 발생 확인1, 에러 발생 확인2
        String s1 = "A" + "B"; // 공백 에러 발생 하지 않음 확인
        System.out.println(s1);
        System.out.println(""+7);
        System.out.println(""+"7");
        System.out.println("7");

        System.out.println(""+7 + 7);
        System.out.println("7"+7);
        System.out.println("7"+"7");
        System.out.println("77");

        System.out.println(7+7+"");
        System.out.println(14+"");
        System.out.println("14"+"");
        System.out.println("14");

        b = 127;
        System.out.println(b);
        b++; // b = b + 1;
        System.out.println(b);

        // 형변환 13분까지 실습
        f = 1.6f;
        i = (int)f; // 1.6 -> 1 (정수, 버림 연산)
        System.out.println(i);

        ch = 'A';
        i = (int)ch;
        System.out.println(i);

        i = 65;
        ch =(char)i;
        System.out.println(ch);

        i = 10;
        f = (float)i;
        System.out.println(f);

        // 값손실 16분까지
        b = 10;
        i =(int) b;
        i = b;
        System.out.println(i);

        int i2 = 300;
        byte b2 = (byte) i2;
        System.out.println(b2);

        // 형식화된 출력 23분까지
        System.out.println(10.0/3);
        System.out.println(0x1A);
        // printf 사용
        System.out.printf("%.5f\n", 10.0/3); // .2f 는 소숫점 2째 자리까지 표현
        System.out.printf("%d\n", 0x1A);
        System.out.printf("%X\n", 0x1A);
        // 3.33
        // 26
        // 1A
        // 3.33261A
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");

        System.out.printf("1\n");
        System.out.printf("2\n");
        System.out.printf("3\n");

        System.out.printf("age:%d year:%d\n", 14, 2017);
        int age = 101;
        System.out.printf("age:%d", age);
        System.out.printf("age:%d%n", age);
        System.out.printf("age:%d", age);

        System.out.printf("This state is %b.%n", true);

        // printf 지시자 2/3 40분까지
        System.out.printf("%d%n", 15); // 10진법
        System.out.printf("%o%n", 15); // 8진법
        System.out.printf("%x%n", 15); // 16진법
        System.out.printf("%s%n", Integer.toBinaryString(15)); // 2진법

        System.out.printf("%#o%n", 15); // 8진법 접두사
        System.out.printf("%#x%n", 15); // 16진법 소문자
        System.out.printf("%#X%n", 15); // 16진법 대문자

        f = 123.4567890f;
        System.out.printf("%f%n", f);
        System.out.printf("%e%n", f);

        System.out.printf("%g%n", 123.456789);
        System.out.printf("%g%n", 0.000000001);

        System.out.println("3 곱하기 4는 12 입니다.");
        int first = 3;
        int second = 4;
        System.out.printf("%d 곱하기 %d는 %d 입니다.%n", first, second, first * second);

        System.out.printf("[%5d]%n", 10);
        System.out.printf("[%-5d]%n", 10);
        System.out.printf("[%05d]%n", 10);

        System.out.printf("d=%14.10f%n", d);

        String url = "www.codechobo.com";
        System.out.printf("[%s]%n", url);
        System.out.printf("[%20s]%n", url);
        System.out.printf("[%-20s]%n", url);
        System.out.printf("[%.8s]%n", url);

        // Scanner scanner = new Scanner(System.in);
        // int num = scanner.nextInt();
        // System.out.println(num);
        
        // scanner = new Scanner(System.in);
        // String input = scanner.nextLine();
        // num = Integer.parseInt(input);
        // System.out.println(num);
        // scanner.close();
    }
}
