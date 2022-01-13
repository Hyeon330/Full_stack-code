import java.util.Scanner;

public class Example01 {
    public static void main(String[] args) {
        // 변수, 상수
        int a=102;
        String s="String33";
        boolean b=false;

        // a=10;
        // s="String";
        // b=true;

        // System.out.println(a);
        // System.out.println(s);
        // System.out.println(b);

        // System.out.printf("정수형 : %d, 문자열 : %s, 불린형 : %b\n", a, s, b);

        long l=10000000000l;
        a=(int) l;
        // System.out.println(a);

        s="1111";
        a=Integer.parseInt(s);

        // System.out.println(a);

        int cash = 102400;
        boolean takenTaxi = false;
        boolean sleeping = false;
        boolean takenBicycle = false;

        if(cash > 4000) {
            takenTaxi = true;
        }

        if(takenTaxi){
            // System.out.println("나는 택시를 타야해!");
        }

        int stressScore = 60; // 잠이 오는 정도
        
        if(stressScore > 80) {
            sleeping = true;
        }

        if(sleeping) {
            // System.out.println("일단 누워자자.");
        }

        int temp = -5;

        if(temp > -5) {
            takenBicycle = true;
        }

        if(takenBicycle) {
            // System.out.println("오늘은 자출족이다.");
        }

        temp = -10;
        stressScore = 90;
        cash = 42400;

        if(cash > 4000) {
            takenTaxi = true;
        }

        sleeping = false;

        if(stressScore > 80) {
            sleeping = true;
        }

        takenBicycle = false;

        if(temp > -5) {
            takenBicycle = true;
        }

        if(takenTaxi && !sleeping && !takenBicycle) {
            // 택시타고, 취침안하고, 자전거 안타고
            // System.out.println("택시타고, 취침안하고, 자전거 안타.");
        } else {
            // System.out.printf("택시 : %b, 취침 : %b, 자전거 : %b", takenTaxi, sleeping, takenBicycle);
        }

        // System.out.println();

        // A와 B를 붙인 수와 C와 D를 붙인 수의 합을 출력한다.
        int A = 10, B = 20, C = 30, D = 40;

        int AB = 0, CD = 0;

        int ABCD = 0;

        AB = Integer.valueOf(Integer.toString(A) + Integer.toString(B));
        CD = Integer.valueOf("" + C + D);

        ABCD = Integer.valueOf(AB + CD);

        // System.out.println(ABCD);

        // 첫째 줄에 입력으로 주어진 단어의 길이를 출력한다.
        String str = "pulljima";
        // System.out.println(str.length());

        // 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.
        char c = 'ⓒ';
        // 0~9 : 48~57
        // ' ' : 32
        // a~z : 97~122
        // A~Z : 65~90

        System.out.println((int) c);

        String input = "asfsadfDSDFSDF  SDFSDF 343434d";
        char[] chArr = input.toCharArray();

        // 배열
        int cntArr[] = new int[4];

        for (char e : chArr) {
            if ((int) e >= 48 && (int) e <= 57 ) {
                cntArr[0]++;
            } else if((int) e == 32) {
                cntArr[1]++;
            } else if((int) e >= 97 && (int) e <= 122) {
                cntArr[2]++;
            } else if((int) e >= 65 && (int) e <= 90) {
                cntArr[3]++;
            }
        }

        System.out.println("num : " + cntArr[0]);
        System.out.println("whiteSpace : " + cntArr[1]);
        System.out.println("lowerCase : " + cntArr[2]);
        System.out.println("upperCase : " + cntArr[3]);

        String strArr[] = new String[4];
        strArr[0] = "num";
        strArr[1] = "wSpace";
        strArr[2] = "lower";
        strArr[3] = "upper";

        // 반복문
        for (int i = 0; i < cntArr.length; i++) {
            String cc = "┌───────┐";
            String c1 = "│" + strArr[i] + "\t│";
            String c2 = "│No. " + cntArr[i] +"\t│";
            String c3 = "│       │";
            String c4 = "└───────┘";
            System.out.println(cc);
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);
        }

        Scanner scanner = new Scanner(System.in);

        while(true) {
            String st = scanner.next();
            System.out.println(st);
            System.out.println(st.equals("w"));
            if(st.equals("w")) {
                String cc = "┌───────┐";
                String c3 = "│   ↑   │";
                String c4 = "└───────┘";
                System.out.println(cc);
                System.out.println(c3);
                System.out.println(c4);
            } else if(st.equals("a")) {
                String cc = "┌───────┐";
                String c3 = "│   ←   │";
                String c4 = "└───────┘";
                System.out.println(cc);
                System.out.println(c3);
                System.out.println(c4);
            } else if(st.equals("s")) {
                String cc = "┌───────┐";
                String c3 = "│   ↓   │";
                String c4 = "└───────┘";
                System.out.println(cc);
                System.out.println(c3);
                System.out.println(c4);
            } else if(st.equals("d")) {
                String cc = "┌───────┐";
                String c3 = "│   →   │";
                String c4 = "└───────┘";
                System.out.println(cc);
                System.out.println(c3);
                System.out.println(c4);

            }
        }

        // 객체지향
    }
}
