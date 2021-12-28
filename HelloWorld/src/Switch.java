import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        // int month = 8;
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

        Scanner sc = new Scanner(System.in);

        // // exam 1
        // int num = 2;
        // switch (num % 2) {
        // case 0:
        // System.out.println("짝수");
        // break;
        // default:
        // System.out.println("홀수");
        // break;
        // }

        // exam 2
        System.out.print("점수 입력 : ");
        try {
            int grade = sc.nextInt();
            if (grade <= 100) {
                switch (grade / 10) {
                    case 9:
                        System.out.println("A");
                        break;
                    case 8:
                        System.out.println("B");
                        break;
                    case 7:
                        System.out.println("C");
                        break;
                    case 6:
                        System.out.println("D");
                        break;

                    default:
                        System.out.println("F");
                        break;
                }
            } else {
                System.out.println("0 ~ 100 사이 값 입력");
            }
        } catch (Exception e) {
            System.out.println("숫자를 입력해 주세요.");
        }

        sc.close();

    }
}
