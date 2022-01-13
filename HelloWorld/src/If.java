import java.util.*;

public class If {
    public static void main(String[] agrs) {
        // int input;

        // System.out.println("숫자를 하나 입력하세요.>");

        // Scanner scanner = new Scanner(System.in);
        // String tmp = scanner.nextLine();

        // input = Integer.parseInt(tmp);

        // if(input%2 == 0){
        // System.out.println("짝수입니다.");
        // } else
        // System.out.println("홀수입니다.");

        // Scanner scanner = new Scanner(System.in);
        // int num = scanner.nextInt();
        // if(num<10) {
        // System.out.println("10보다 작습니다.");
        // }

        // int money = 34000;
        // if (money >= 3000) {
        // System.out.println("택시를 타고 가라.");
        // } else {
        // System.out.println("걸어가라.");
        // }

        // int money = 2000;
        // boolean hasCard = true;

        // if(money >= 3000 || hasCard) {
        // System.out.println("택시를 타고 가라");
        // } else {
        // System.out.println("걸어 가라");
        // }

        // 문제) 변수 a 는 4 이면서, 변수 b 는 짝수이고, 변수 c 는 true 가 아닐 경우 "정답입니다."를 출력하시오.
        // int a = 14;
        // int b = 3;
        // boolean c = false;

        // if(a == 4 && b%2 == 0 && c != true) {
        // System.out.println("정답입니다.");
        // }

        // 문제) 변수 a 가 10보다 크거나 5보다 작으면서 변수 b가 홀수일 경우 "정답입니다."를 출력하시오.
        // int a = 14;
        // int b = 3;
        // boolean c = false;
        // if(a>10 || a<5 && b%2==1)
        // System.out.println("정답입니다.");

        // int A;
        // int B;
        // boolean C;

        // Scanner scan = new Scanner(System.in);

        // System.out.print("A : ");
        // A = scan.nextInt();
        // System.out.print("B : ");
        // B = scan.nextInt();
        // System.out.print("C : ");
        // C = scan.nextBoolean();

        // if (A == 4 && B%2 ==0 && C == true)
        // System.out.println("정답");

        // if (A == 4){
        // if (B%2 ==0){
        // if (C == true){
        // System.out.println("정답");
        // }
        // }
        // }

        // 문제) 변수 a 가 -10보다 작거나 같고, 변수 b가 10보다 작으면서, a * b 가 100보다 크면 "정답입니다."를 출력하시오.
        // Scanner s = new Scanner(System.in);

        // System.out.print("a 입력: ");
        // // int a = Integer.parseInt(s.next());
        // int a = s.nextInt();

        // System.out.print("b 입력: ");
        // // int b = Integer.parseInt(s.next());
        // int b = s.nextInt();

        // if (a <= -10 && b < 10 && a * b > 100)
        // System.out.println("정답입니다.");
        // s.close();

        // Scanner sc = new Scanner(System.in);
        // int num = sc.nextInt();
        // if (num % 2 == 0) {
        // System.out.println("출력:짝수");
        // } else {
        // System.out.println("출력:홀수");
        // }
        // sc.close();

        // int input;
        // System.out.print("숫자를 하나 입력하세요. : ");

        // Scanner scanner = new Scanner(System.in);
        // input = scanner.nextInt();
        // if (input % 2 == 0) {
        // System.out.println("짝수");
        // } else {
        // System.out.println("홀수");
        // }
        // scanner.close();

        // Scanner scanner = new Scanner(System.in);
        // int num = scanner.nextInt();
        // if (num % 2 == 0) {
        // System.out.printf("%d는 짝수", num);
        // } else {
        // System.out.printf("%d는 홀수", num);
        // }

        // scanner.close();

        // Scanner score_scanner = new Scanner(System.in);

        // int a = (int) (Math.random() * 100) + 1;

        // System.out.println("성적 : " + a);

        // if (a > 90) {
        // System.out.println("수 입니다");
        // } else if (a > 80) {
        // System.out.println("우 입니다");
        // } else if (a > 70) {
        // System.out.println("미 입니다");
        // } else if (a > 60) {
        // System.out.println("양 입니다");
        // } else {
        // System.out.println("가 입니다");
        // }

        // score_scanner.close();

        // int S = (int) (Math.random() * 100);
        // System.out.println(S);
        // if (S <= 60) {
        // System.out.println("가");
        // } else if (S <= 70) {
        // System.out.println("양");
        // } else if (S <= 80) {
        // System.out.println("미");
        // } else if (S <= 90) {
        // System.out.println("우");
        // } else {
        // System.out.println("수");
        // }

        // double dValue = Math.random(); // 난수 발생 코드
        // int randomValue = (int) (dValue * 100); // 0-100난수 발생

        // if (randomValue >= 91) {
        // System.out.println("수");
        // } else if (randomValue >= 81) {
        // System.out.println("우");
        // } else if (randomValue >= 71) {
        // System.out.println("미");
        // } else if (randomValue >= 61) {
        // System.out.println("양");
        // } else {
        // System.out.println("가");
        // }

        // double dValue = Math.random();
        // int randomValue = (int) (dValue * 100);
        // if (randomValue <= 60) {
        // System.out.printf("점수:%d 성적:가", randomValue);
        // } else if (randomValue <= 70) {
        // System.out.printf("점수:%d 성적:양", randomValue);
        // } else if (randomValue <= 80) {
        // System.out.printf("점수:%d 성적:미", randomValue);
        // } else if (randomValue <= 90) {
        // System.out.printf("점수:%d 성적:우", randomValue);
        // } else {
        // System.out.printf("점수:%d 성적:수", randomValue);
        // }

        // double dValue = Math.random();
        // System.out.println(dValue);
        // int randomValue = (int) (dValue * 100);
        // System.out.println(dValue * 100);
        // System.out.println(randomValue);

        // int a = 10, b = 20, c = 9;
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
        // System.out.println("max = " + max);

        // int a = 10, b = 20, c = 9;
        // int max;
        // if (a > b && a > c) { // a는 가장 큰 수 인가?
        // max = a; // 참이면 a를 max로
        // } else { // a가 최대값이 아니라면, b와 c 비교
        // if (b > c) { // b가 c 보다 크면
        // max = b; // max는 b
        // } else { // b가 c 보다 크지 않으면
        // max = c; // max는 c
        // }
        // }
        // System.out.println("max = " + max);

        // Scanner scan = new Scanner(System.in);
        // int a = scan.nextInt();
        // int b = scan.nextInt();
        // int c = scan.nextInt();

        // int max = a;
        // if (b > max)
        // max = b;
        // if (c > max)
        // max = c;

        // System.out.println("최댓값은" + max);

        // int age = 62;

        // if (age >= 20 && age < 30) {
        // System.out.println("20대");
        // } else if (age < 20) {
        // System.out.println("10대 이하");
        // } else if (age > 29 && age < 40) {
        // System.out.println("30대");
        // } else if (age > 39 && age < 50) {
        // System.out.println("40대");
        // } else if (age > 49 && age < 60) {
        // System.out.println("50대");
        // } else {
        // System.out.println("60대 이상");
        // }

        // 주사위 뽑기
        // 난수 발생 코드
        // int num = (int) (Math.random() * 6) + 1;
        // System.out.println(num);

        // int num = (int) (Math.random() * 6) + 1;
        // System.out.println(num + "번이 나왔습니다");

        // int userID = 3; // 1 관리자, 2 판매자, 3 구매자
        // int password = 1234;
        // if (userID == 1) {
        // // System.out.println("관리자로 로그인 하였습니다.");
        // } else if (userID == 2) {
        // System.out.println("판매자로 로그인 하였습니다.");
        // } else {
        // System.out.println("구매자로 로그인 하였습니다.");
        // }

        // 문제) userID가 1이면 관리자 2이면 판매자 3이면 구매자이다.
        // userID를 확인하여 누가 로그인했는지 출력하고
        // 관리자의 경우 password 가 1234와 일치하면
        // "관리자로 로그인 하였습니다."를 출력하시오.

        // Scanner sc = new Scanner(System.in);
        // System.out.print("userID를 입력하세요 : ");
        // int userID = sc.nextInt();
        // if (userID == 1) {
        // Scanner sc1 = new Scanner(System.in);
        // System.out.print("패스워드를 입력하세요 : ");
        // int password = sc1.nextInt();
        // if (password == 1234) {
        // System.out.println("관리자로 로그인 하였습니다.");
        // } else {
        // System.out.println("틀렸습니다.");
        // }
        // sc1.close();
        // } else if (userID == 2) {
        // System.out.println("판매자로 로그인 하였습니다.");
        // } else if (userID == 3) {
        // System.out.println("구매자로 로그인 하였습니다.");
        // }
        // sc.close();

        // Scanner scan = new Scanner(System.in);
        // System.out.print("아이디는?: ");
        // int userID = scan.nextInt();
        // if (userID == 1) {
        // System.out.print("암호가 무엇일까요?: ");
        // int password = scan.nextInt();
        // if (password == 1234) {
        // System.out.println("some texts.");
        // }
        // } else if (userID == 2) {
        // System.out.println("판매자로 로그인 하였습니다.");
        // } else if (userID == 3) {
        // System.out.println("관리자로 로그인 하였습니다.");
        // }

        // Scanner scanner = new Scanner(System.in);
        // int userID;
        // int userPW;
        // String user = "";

        // userID = scanner.nextInt();

        // if (userID == 1) {
        // userPW = scanner.nextInt();
        // if (userPW == 1234) {
        // user = "관리자";
        // }
        // } else if (userID == 2) {
        // user = "판매자";
        // } else if (userID == 3) {
        // user = "구매자";
        // } else {
        // System.out.println("ID를 확인해주세요");
        // }

        // if (user.isEmpty() != true)
        // System.out.printf("%d: %s로 로그인 하였습니다.", userID, user);
        // scanner.close();

        // int userID = 3; // 1 관리자, 2판매자, 3구매자
        // int password = 1234;
        // Scanner scan = new Scanner(System.in);
        // System.out.println("ID : ");
        // userID = scan.nextInt();
        // System.out.println("P/W : ");
        // password = scan.nextInt();

        // if (userID == 1) {
        //     if (password == 1234) {
        //         System.out.println("관리자로 로그인 하였습니다.");
        //     } else {
        //         System.out.println("정보가 일치하지 않습니다.");
        //     }
        // } else if (userID == 2) {
        //     System.out.println("판매자로 로그인 하였습니다.");
        // } else if (userID == 3) {
        //     System.out.println("구매자 로그인 하였습니다.");
        // } else {
        //     System.out.println("정보가 일치하지 않습니다.");
        // }
    }
}
