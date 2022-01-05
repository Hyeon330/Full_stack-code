package onetosevenChapter;
public class For {
    public static void main(String[] args) {
        // exam 2
        // int sum = 0;
        // for (int i = 93; i >= 50; i--) {
        // sum += i;
        // }
        // System.out.println(sum);

        // // exam 3
        // for (int i = 1; i <= 5; i++) {
        // for (int j = 1; j <= i; j++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // // 박경태님 코드 굳(중첩for문 없이)
        // int i;
        // String s = "*";

        // for (i = 1; i <= 5; i++) {
        // System.out.println(s);
        // s += "*";
        // }

        // // exam 4
        // for (int i = 1; i <= 10; i++) {
        // for (int j = 1; j <= 10; j++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // // exam 5
        // System.out.println("구구단");
        // for (int i = 2; i <= 9; i++) {
        // System.out.println(i + "단");
        // for (int j = 1; j <= 9; j++) {
        // System.out.println(i + " x " + j + " = " + i * j);
        // }
        // System.out.println();
        // }
        // int star = 0;
        // for (int i = 5; i >= 1; i--) {
        // for (int j = 1; j <= i - 1; j++) {
        // System.out.print("*");
        // }
        // for (int k = 1; k <= 1 + star; k++) {
        // System.out.print("#");
        // }
        // System.out.println();
        // star += 2;
        // }
        // for (int i = 1; i <= 5; i++) {
        // star -= 2;
        // for (int j = 1; j <= i - 1; j++) {
        // System.out.print("*");
        // }
        // for (int k = 1; k <= 1 + star; k++) {
        // System.out.print("#");
        // }
        // System.out.println();
        // }

        // // 마름모 찍기
        // final int STAR = 5;
        // for (int i = 1; i <= STAR; i++) {
        // for (int j = 0; j < STAR - i; j++) {
        // System.out.print(" ");
        // }
        // for (int k = 0; k < i * 2 - 1; k++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }
        // for (int i = STAR - 1; i >= 1; i--) {
        // for (int j = 0; j < STAR - i; j++) {
        // System.out.print(" ");
        // }
        // for (int k = 0; k < i * 2 - 1; k++) {
        // System.out.print("*");
        // }
        // System.out.println();
        // }

        // int num = 5;
        // System.out.println(String.format("%" + num + "s", "*"));

        // final int STARLINE = 5;
        // // int HalfLine = (int) Math.ceil((float) STARLINE / 2);

        // for (int i = 1; i <= STARLINE; i++) {
        // for (int j = 0; j < STARLINE + i; j++) {
        // if (j <= STARLINE - i) {
        // System.out.print("#");
        // } else {
        // System.out.print("*");
        // }
        // }
        // System.out.println();
        // }
        // for (int i = STARLINE - 1; i >= 1; i--) {
        // for (int j = 0; j <= STARLINE + i - 1; j++) {
        // if (j <= STARLINE - i) {
        // System.out.print("#");
        // } else {
        // System.out.print("*");
        // }
        // }
        // System.out.println();
        // }
    }
}