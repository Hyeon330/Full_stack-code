import java.util.*;

public class While {
    public static void main(String[] args) {
        // int i = 1; // 초기값
        // while (i <= 10) { // 조건식
        // System.out.println(i + " : 현재 숫자");
        // i++; // 증감식
        // }

        // int sum = 0, odd = 0, even = 0;
        // int i = 1;
        // while (i <= 100) {
        // // 총합 구하기
        // sum += i;

        // if (i % 2 == 0) {
        // // 짝수합 구하기
        // even += i;
        // }

        // if (i % 2 == 1) {
        // // 홀수합 구하기
        // odd += i;
        // }

        // i++;
        // }
        // System.out.println("1~100 합 = " + sum);
        // System.out.println("1~100 짝수합 = " + even);
        // System.out.println("1~100 홀수합 = " + odd);

        // boolean stop = false;
        // int num;
        // while (!stop) { // true를 의미
        // System.out.println("2개의 정수 입력");
        // Scanner sc = new Scanner(System.in); // Scanner 객체 생성
        // int num1 = sc.nextInt(); // 콘솔창을 통해 값을 입력을 받음
        // int num2 = sc.nextInt(); // 콘솔창을 통해 값을 입력을 받음
        // num = num1 % num2; // 나머지 구하는 공식
        // System.out.println(num1 + " % " + num2 + " = " + num);
        // System.out.println("계속 Y, 종료 N 입력");
        // String yn = sc.next(); // 콘솔창을 통해 값을 입력을 받음
        // if (yn.equals("Y") || yn.equals("y")) { // Y 또는 y 입력시 반복
        // System.out.println("---------------------");
        // continue; // 보조제어문(반복 계속)
        // }
        // if (yn.equals("N") || yn.equals("n")) { // N 또는 n 입력시 종료
        // break; // 보조제어문(반복 종료)
        // }
        // }
        // System.out.println("시스템이 종료되었습니다.");

        // char c = 'A';
        // while(c <= 'Z') {
        // System.out.print(c);
        // c++;
        // }

        // char a = 65;
        // while (true){
        // System.out.print(a);
        // a++;
        // if(a==91){
        // break;
        // }
        // }

        // int num = 65;
        // while (num < 91) {
        // System.out.print((char) num);
        // num++;
        // }
        // char num = 65;
        // while(num>=90) {
        // System.out.print(num);
        // num++;
        // }

        // Scanner s = new Scanner(System.in);
        // int num;
        // int rand = (int) (Math.random() * 101);
        // System.out.println("정답은 " + rand);
        // do {
        //     System.out.print("내가 생각한 숫자는 무엇일까요? : ");
        //     num = s.nextInt();
        //     if (num < rand)
        //         System.out.println("더 큰 수로 다시 시도해보세요");
        //     else if (num > rand)
        //         System.out.println("더 작은 수로 다시 시도해보세요");
        //     // else break;
        // } while (num != rand);
        // System.out.println("정답입니다!");

        // double dValue = Math.random();
        // int randomValue = (int) (dValue * 100) + 1;
        // int num = 0;

        // do {
        //     System.out.println("숫자를 입력하세요:");
        //     Scanner scan = new Scanner(System.in);
        //     num = scan.nextInt();
        //     if (num > randomValue) {
        //         System.out.println("더 작은 수로 다시 시도해보세요.");
        //     } else {
        //         System.out.println("더 큰 수로 다시 시도해보세요.");
        //     }
        // } while (num != randomValue);
        // System.out.println("정답입니다." + randomValue);
        // int i = 1;
        // do {
        //     System.out.println("숫자를 입력하세요: ");
        //     Scanner scan = new Scanner(System.in);
        //     i = scan.nextInt();
        // } while (i != 10);
        // System.out.println("정답입니다.");

    }
}
