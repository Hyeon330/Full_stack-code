import java.util.*;

public class Switch {
    public static void main(String[] args) {
        // int month = 12;
        // String monthString = "";
        // switch (month) {
        // case 1:
        // monthString = "January";
        // break;
        // case 2:
        // monthString = "February";
        // break;
        // case 3:
        // monthString = "March";
        // break;
        // case 4:
        // monthString = "April";
        // break;
        // case 5:
        // monthString = "May";
        // break;
        // case 6:
        // monthString = "June";
        // break;
        // case 7:
        // monthString = "July";
        // break;
        // case 8:
        // monthString = "August";
        // break;
        // case 9:
        // monthString = "September";
        // break;
        // case 10:
        // monthString = "October";
        // break;
        // case 11:
        // monthString = "November";
        // break;
        // case 12:
        // monthString = "December";
        // break;
        // default:
        // monthString = "Invalid month";
        // break;
        // }

        // System.out.println(monthString);

        // int num = 6;
        // String text = "";
        // switch (num % 2) {
        // case 1:
        // text = "홀수";
        // break;
        // case 0:
        // text = "짝수";
        // break;
        // default:
        // text = "none";
        // break;

        // }

        // System.out.println(text);

        // int num;
        // String result = "";
        // Scanner scan = new Scanner(System.in);
        // num = scan.nextInt();

        // switch(num%2){
        // case 0: result = "짝수";
        // break;
        // case 1: result = "홀수";
        // break;
        // }
        // System.out.println(result);

        // Scanner sc1 = new Scanner(System.in);
        // System.out.print("숫자를 입력하세요.>");
        // int num = sc1.nextInt();
        // switch (num % 2 == 0 ? 1 : 2) {
        // case 1:
        // System.out.println("짝수");
        // break;
        // case 2:
        // System.out.println("홀수");
        // break;
        // }
        // sc1.close();

        // 단항 연산자
        // i++, i--, ++i, --i, +i, -i, !b

        // 이항 연산자
        // a + b, a - b, a * b, a / b, a % 2

        // 삼항 연산자
        // num % 2 == 0 ? 1 : 2
        // (num % 2 == 0) ? (1) : (2)
        // (조건식)?(참이면):(거짓이면)
        // switch((num % 2 == 0) ? (1) : (2))

        System.out.print("점수를 입력하세요 : ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        String str = "";
        switch (num / 10 + 1) {
            // num = 91 => 9.1 => 9 => 10
            // num = 100 => 10 => 11
            // 의도 : 0 ~ 100, A,B,C,D,F
            case 10:
                str = "A";
                break;
            case 9:
                str = "B";
                break;
            case 8:
                str = "C";
                break;
            case 7:
                str = "D";
                break;
            default:
                str = "F";
                break;
        }
        System.out.println("당신은 " + str + " 점입니다.");
        scan.close();
    } // !!!!!!!!!!!!!!!질문 필요!!!!!!!!!!!!!!!!!!!!!
}
