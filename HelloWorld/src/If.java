import java.util.Scanner;

public class If {
    public static void main(String[] args) {
        // if (true) {
        // System.out.println("실행 1");
        // }

        // if (false) {
        // System.out.println("실행 2");
        // System.out.println("실행 3");
        // }

        // int a = 6;
        // if (a % 2 == 0) {
        // System.out.println(a + "는 2의 배수");
        // }

        Scanner scan = new Scanner(System.in);
        // int num = 0;

        // // example
        // System.out.print("숫자 하나 입력>");
        // String tmp = scan.nextLine();
        // num = Integer.parseInt(tmp);
        // if (num == 0) {
        // System.out.println("입력하신 숫자는 0입니다.");
        // }
        // if (num != 0) {
        // System.out.println("입력하신 숫자는 0이 아닙니다.");
        // System.out.println("입력하신 숫자는 " + num + "입니다.");
        // }

        // // exam1
        // System.out.print("입력 : ");
        // num = scan.nextInt();
        // System.out.print("출력 : ");
        // if (num < 10) {
        // System.out.println("10보다 작습니다");
        // }

        // // exam2
        // System.out.print("입력 : ");
        // num = scan.nextInt();
        // System.out.print("출력 : ");
        // if (num % 2 == 0) {
        // System.out.println("짝수입니다.");
        // }

        // // exam 3
        // int num1 = 4;
        // int num2 = 2;
        // boolean boo = false;
        // if (num1 == 4 && num2 % 2 == 0 && !boo) {
        // System.out.println("정답입니다.");
        // }

        // // exam 4
        // num1 = 11;
        // num2 = 3;
        // if (num1 > 10 || num1 < 5 && num2 % 2 == 1) {
        // System.out.println("정답입니다.");
        // }

        // // exam 5
        // num1 = -10;
        // num2 = -11;
        // int num3 = num1 * num2;
        // if (num1 >= -10 && num2 < 10 && num3 > 100) {
        // System.out.println("정답입니다.");
        // }

        // if else
        // // exam 1
        // System.out.print("입력 : ");
        // int num = scan.nextInt();

        // System.out.print("출력 : ");
        // if (num % 2 == 0) {
        // System.out.println("짝수");
        // } else {
        // System.out.println("홀수");
        // }

        // // exam 2
        // // 난수 발생 코드
        // double dValue = Math.random();
        // int randomValue = (int) (dValue * 100);

        // System.out.println("점수 : " + randomValue);
        // if (randomValue < 60) {
        // System.out.println("60점 이하 : 가");
        // } else if (randomValue <= 70) {
        // System.out.println("61점 ~ 70점 : 양");
        // } else if (randomValue <= 80) {
        // System.out.println("71점 ~ 80점 : 미");
        // } else if (randomValue <= 90) {
        // System.out.println("81점 ~ 90점 : 미");
        // } else {
        // System.out.println("91점 이상 : 수");
        // }

        // // exma 3
        // int a = 10, b = 9, c = 11;
        // int max;

        // if (a > b && a > c) { // 부등호와 논리연산자 사용
        // max = a; // 위의 조건식이 true일때 실행
        // } else { // 위의 조건식이 false일때 실행
        // if (b > c) {
        // max = b; // 위의 조건식 true일때 실행
        // } else {
        // max = c; // 위의 조건식 false일때 실행
        // }
        // }
        // // // 박경태님 코드 굳~~
        // // max = a;
        // // if( b > max ) max = b;
        // // if( c > max ) max = c;

        // System.out.println("max = " + max);

        scan.close();
    }
}