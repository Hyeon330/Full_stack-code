import java.util.*;

public class For {
    public static void main(String[] args) {
        // int sum = 0;
        // for (int i = 93; i >= 50; i--) {
        // sum += i;
        // }
        // System.out.println(sum);

        // int sum = 0; // 90~53까지의 합
        // for (int i = 93; i > 52; --i) {
        // sum = sum + i;
        // System.out.println("i = " + i + "," + "sum = " + sum);
        // }
        // System.out.println("93부터 53까지의 합 : " + sum);

        // int sum = 0;
        // for(int i = 93; i >= 50; i--) {
        // sum += i;
        // }
        // System.out.println(sum);
        // int sum = 0;
        // int i;
        // for(i=93; i>50; i--){
        // sum += i;
        // System.out.println(sum);
        // }
        // System.out.println("정답 = " + (sum+i));

        // int sum = 0;
        // for(int i=93; i>= 50; i--){
        // sum = sum + i;
        // }
        // System.out.println(sum);

        // int i, sum = 0;

        // for(i=93; i >= 50; i--){
        // sum += i;
        // }
        // System.out.println(sum);

        // for(int i=0; i<5; i++){
        // for(int j=0; j<=i; j++){
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // String star = "*";

        // for (int i = 1; i <= 5; i++) {
        // System.out.println(star.repeat(i));
        // }

        // for (int i = 1; i <= 5; i++) {
        // for (int j = 1; j <= i; j++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // for (int i = 0; i < 5; i++) {
        // for (int j = 0; j < i + 1; j++) {
        // System.out.print("*");
        // }
        // System.out.println("");
        // }

        // System.out.println("*");
        // System.out.println("**");
        // System.out.println("***");
        // System.out.println("****");
        // System.out.println("*****");

        // int i;
        // String s = "*";

        // for ( i = 1; i <= 5; i++) {
        // System.out.println(s);
        // s += "*";
        // }

        // int n = 0;
        // for (int i = 0; i < 10; i++) {
        // for (int j = 0; j < 10; j++) {
        // n += 1; // n = n + 1; n++;
        // // n += 2; // n = n + 2;
        // // n *= 2; // n = n * 2;
        // System.out.print(n + "\t");
        // }
        // System.out.println();
        // }

        // for (int a = 1; a <= 10; a++) {
        // for (int b = 0; b <= 10; b++) {
        // System.out.print("*");
        // }
        // System.out.println("");
        // }

        // 2중 for 문
        // for 문

        // for (int a = 1; a <= 10; a++) {
        // for (int b = 1; b <= 10; b++) {
        // System.out.println("b->" + b);
        // }
        // System.out.println("a->" + a);
        // }

        // for (int i = 1; i <= 10; i++) {
        // for (int j = 1; j <= 10; j++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // for (int a = 1; a < 10; a++) {
        // for (int b = 1; b < 10; b++) {
        // int sum = a * b;
        // System.out.println(sum);
        // }
        // }

        // for (int i=2; i<10; i++) {
        // System.out.println(i + "단을 출력합니다");
        // for (int j=1; j<10; j++) {
        // int result = i * j;
        // System.out.printf("%dx%d=%d\n", i, j, result);
        // }
        // System.out.println("...");
        // }

        // for(int i = 2; i < 10; i++){
        // System.out.printf("---- %d 단 ----\n", i);
        // for(int j = 1; j < 10; j++){
        // System.out.printf("%d x %d = %d\n", i, j, i*j);
        // }
        // System.out.println();
        // }

        // for(int i = 2; i < 10; i++) {
        // for(int j = 1; j < 10; j++) {
        // System.out.printf("|%2d *%2d = %2d |", i, j, i*j);
        // }
        // System.out.println();
        // }

        // System.out.println("구구단");
        // for (int i = 2; i <= 9; i++) {
        // System.out.println(i + "단");
        // for (int j = 1; j <= 9; j++) {
        // System.out.println(i + " x " + j + " = " + i * j);
        // }
        // System.out.println();
        // }

        // 별을 마름모로 찍기
        // 1 2 3 4 5
        //     *
        //   * * *
        // * * * * *
        //   * * *
        //     *

        // for (int i = 1; i <=9; i++) {
        // for (int j = 1 ; j <=9; j++) {
        // System.out.printf("%d x %d = %d\n", i, j, i*j);
        // }
        // }

        // for(int a = 1; a<10; a++){
        // for (int b=1; b<10;b++){
        // System.out.println(a+"x"+b+"="+a*b);
        // }
        // }

        // for(int j = 1; j <= 9; j++){
        // System.out.println(j+"단 출력");
        // for (int i = 1; i <= 9; i++) {
        // System.out.printf("%d * %d = %d\n", j, i, j * i);

        // }
        // }

        // for(int a = 1; a<10; a++){
        // for (int b=1; b<10;b++){
        // System.out.println(a+"x"+b+"="+a*b);
        // }
        // }

        // for(int j = 1; j <= 9; j++){
        // System.out.println(j+"단 출력");
        // for (int i = 1; i <= 9; i++) {
        // System.out.printf("%d * %d = %d\n", j, i, j * i);

        // }

        // }

        // for (int i = 2; i <= 9; i++) {
        // int num;
        // for (int j = 1; j <= 9; j++) {
        // num = i * j;
        // System.out.println(i + "X" + j + "=" + num);

        // }
        // System.out.println(i + "단을 출력합니다.");
        // }

        final int COUNT = 10;
        for (int i = 1; i <= COUNT / 2; i++) {
            for (int j = COUNT / 2 - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("☆");
            }
            System.out.println();
        }
        for (int i = 1; i <= COUNT / 2 - 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = COUNT - (i * 2 + 1); j > 0; --j) {
                System.out.print("☆");
            }
            System.out.println();
        }

        // for(int i =2; i<=9; i++){
        // int num;
        // System.out.println(i+"단을 출력합니다.");
        // for(int j=1; j<=9; j++){
        // num = i*j;
        // System.out.println(i + "X" + j + "=" + num);

        // }
        // System.out.println("\n");
        // }

        // for (int i = 2; i <10; i++) {
        // System.out.printf("\n%d단",i);
        // for (int j = 1; j <10; j++) {
        // System.out.printf("\n%d X %d = %d",i,j,i*j);
        // }
        // System.out.println();
        // }

        // int sum = 0;
        // for (int i = 1; i <= 100; i++) {
        // if (i % 3 == 0 && i % 5 == 0) {
        // sum += i;
        // System.out.print(i + " ");
        // }
        // }

        // System.out.print("\n합계 :" + sum);

        // System.out.print("숫자를 입력하세요 : ");

        // int num = new Scanner(System.in).nextInt();

        // for (int i = num; i <= num * 10; i += num) {
        // System.out.print(i + " ");
        // }

        // for (int y = 0; y < 3; y++) {
        //     System.out.print(" ");
        // }
        // System.out.println("*");

        // int x = 0;
        // for (int y = 0; y < 5; y++) {
        //     if (y <= 1) {
        //         System.out.print(" ");
        //     } else if (1 < y && y < 5) {
        //         System.out.print("*");
        //     } else {
        //         System.out.print(" ");
        //     }
        // }

        // System.out.println();
        // System.out.print(" ");

        // for (int y = 1; y <= 5; y++) {
        //     System.out.print("*");
        // }

        // System.out.println();

        // for (int y = 0; y < 5; y++) {
        //     if (y <= 1) {
        //         System.out.print(" ");
        //     } else if (1 < y && y < 5) {
        //         System.out.print("*");
        //     } else {
        //         System.out.print(" ");
        //     }
        // }

        // System.out.println();

        // for (int y = 0; y < 3; y++) {
        //     System.out.print(" ");
        // }
        // System.out.println("*");

        // for (int i = 1; i < 4; i++) {
        //     for (int l = 0; l < 3 - i; l++) {
        //         System.out.print(" ");
        //     }
        //     for (int j = 0; j < (2 * i - 1); j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println("");
        // }
        // for (int i = 2; i > 0; i--) {
        //     for (int l = 3 - i; l > 0; l--) {
        //         System.out.print(" ");
        //     }
        //     for (int j = (2 * i - 1); j > 0; j--) {
        //         System.out.print("*");
        //     }
        //     System.out.println("");
        // }

    }
}
