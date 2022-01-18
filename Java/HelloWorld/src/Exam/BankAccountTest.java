/*
문제
은행 계좌를 나타내는 BankAccount 순수 클래스를 만든다.
BankAccount는 잔고를 나타내는 정수형 멤버 변수
    * blance : 정수형 멤버 변수, 추후 Double 변경
메소드
    * withdraw() : 예금 인출 메소드
    * deposit() : 예금 메소드
    * getBlance() : 현재 잔고확인 메소드

BankAccount 클래스를 사용할 main() 함수메소드 포함한 클래스 생성
public class BankAccountTest {
    public static void main(String[] args){

    }
}

main() 메소드 안에서 BankAccount 객체 b를 생성하고 다음과 같은 순서로 메소드를 호출함
    * b의 잔고를 100으로 한다.
    * b에서 60을 인출한다.
    * b의 현재 잔고를 얻어서 화면에 출력한다.

현재 잔액에 대하여 연 7.5%이자를 계산하여 추가하는 addInterest() 메소드를 구현
현재 잔고가 음수 이면 예금 인출이 일어나지 않도록 withdraw()메소드를 변경
*/
package Exam;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount b = new BankAccount(100);

        b.getBlance();

        final int WITHDRAWAL = 60;

        b.withdraw(WITHDRAWAL);
        b.getBlance();
        b.addInterest();
        b.addInterest();
        b.addInterest();
        b.getBlance();
    }
}

class BankAccount {
    private double balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    // 예금 인출 메소드
    void withdraw(int minus) {
        if (minus < 0 || this.balance - minus < 0) {
            System.out.println("인출할 수 없습니다.");
        } else if (minus == 0) {
            System.out.println("금액이 인출되지 않았습니다.");
        } else {
            this.balance -= minus;
            System.out.println(minus + "만원 인출");
        }

    }

    // 예금 메소드
    void deposit(int plus) {
        this.balance += plus;
    }

    // 현재 잔고확인 메소드
    void getBlance() {
        System.out.println("남은 금액 : " + (int) (this.balance * (double) 10000) + "원");
    }

    // 7.5%이자 추가
    void addInterest() {
        this.balance *= 1.075d;
    }
}
