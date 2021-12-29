import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        // // exam 1
        // int[] score = { 50, 60, 70, 80, 90 };
        // for (int s : score) {
        // System.out.println(s);
        // }

        // // exam 2
        // char[] chArr = { 'a', 'b', 'c', 'd', 'e' };
        // for (char f : chArr) {
        // System.out.println(f);
        // }

        // // exam 2 박경태님 코드 굳(ASCII코드 활용)
        // char[] chArr = new char[5];
        // for (int i = 0; i < chArr.length; i++) {
        // chArr[i] = (char) ('a' + i);
        // System.out.printf("chArr[%d]:%c%n", i, chArr[i]);
        // }

        // // exam 4
        // int[] score = { 50, 60, 70, 80, 90 };
        // System.out.println(score[0] + score[score.length - 1]);

        // exam 5
        // int[] arr = { 100, 88, 100, 100, 90 };
        // float total = 0;
        // for (int i : arr) {
        // total += i;
        // }
        // System.out.println(total);
        // System.out.println(String.format("%.3f", total / (float) arr.length));

        // // 에제 max min
        // int[] score = { 79, 88, 91, 33, 100, 55, 95 };

        // int max = score[0];
        // int min = score[0];

        // for (int i = 1; i < score.length; i++) {
        // if (score[i] > max) {
        // max = score[i];
        // } else if (score[i] < min) {
        // min = score[i];
        // }
        // }

        // System.out.println("max:" + max);
        // System.out.println("min:" + min);

        // // exam 6
        // int a = 10;
        // int b = 20;
        // int tmp = 0;

        // tmp = a;
        // a = b;
        // b = tmp;

        // System.out.println(a + "" + b);

        // // exam 7
        // int[] arr = { 75, 100, 85, 60, 95 };
        // System.out.println("score rank");
        // for (int i : arr) {
        // int rank = 1;
        // for (int j : arr) {
        // if (i < j) {
        // rank++;
        // }
        // }
        // System.out.println(i + " " + rank);
        // }

        // int[] arr = { 75, 100, 85, 60, 95 };
        // Arrays.sort(arr);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.printf("%d %d \n", arr[i], (arr.length - i));
        // }

        // // 섞기(Shuffle)
        // int[] numArr = new int[10];
        // for (int i = 0; i < numArr.length; i++) {
        // numArr[i] = i;
        // System.out.print(numArr[i]);
        // }

        // System.out.println();

        // for (int i = 0; i < 100; i++) {
        // int n = (int) (Math.random() * 10);
        // int tmp = numArr[0];
        // numArr[0] = numArr[n];
        // numArr[n] = tmp;
        // }

        // for (int i = 0; i < numArr.length; i++) {
        // System.out.print(numArr[i]);
        // }

        // // 임의의 값으로 배열 채우기
        // int[] arr = new int[5];

        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = (int) (Math.random() * 5);
        // }

        // exam
        // 거스름돈에 동전의 단위마다 몇개의 동전이 필요한지 출력
        // ex) 거스름돈:2860원 / 500원:5개 / 100원:3개 / 50원:1개 / 10원:1개
        // int[] changeMny = { 1000, 500, 100, 50, 10 };
        // int money = 2860;
        // System.out.print("거스름돈 : " + money + "원");

        // for (int i = 0; i <= changeMny.length - 1; i++) {
        // System.out.print(" / " + changeMny[i] + "원:" + money / changeMny[i] + "개");
        // money %= changeMny[i];
        // }

        // exam
        // 1~5 사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만들어주세요.
        // ex)[1,3,3,2,1,1,4,5,5,1,3] -> [1,3,2,4,5]
        // int[] arr = new int[10];
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = (int) (Math.random() * 5 - 1);
        // }

        // int count = 0;

        // for (int i = 1; i < arr.length; i++) {
        // for (int j = i - 1; j >= 0; j--) {
        // if (arr[i] == arr[j]) {
        // count++;
        // break;
        // }
        // }
        // }
        // int[] changeArr = new int[arr.length - count];
        // changeArr[0] = arr[0];
        // count = 1;
        // for (int i = 1; i < arr.length; i++) {
        // boolean check = true;
        // for (int j = i - 1; j >= 0; j--) {
        // if (arr[i] == arr[j]) {
        // check = false;
        // break;
        // }
        // }
        // if (check) {
        // changeArr[count] = arr[i];
        // count++;
        // }
        // }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(changeArr));

        // ArrayList<Integer> arr = new ArrayList<Integer>();
        // int arrSize = 10;
        // for (int i = 0; i < arrSize; i++) {
        // arr.add((int) (Math.random() * 5 + 1));
        // }
        // System.out.println(arr);
        // for (int i = 1; i < arrSize; i++) {
        // for (int j = i - 1; j >= 0; j--) {
        // if (arr.get(i) == arr.get(j)) {
        // arr.remove(i);
        // i--;
        // arrSize--;
        // break;
        // }
        // }
        // }
        // System.out.println(arr);

        // exam 중복제거 위에문제 (백용민님 코드)
        // // int[] random = new int[10];
        // // for (int i = 0; i < random.length; i++) {
        // // random[i] = (int) (Math.random() * 10 + 1);
        // // }
        // int[] random = { 2, 4, 5, 1, 1, 2, 2, 0, 5, 3, 0 };

        // int count = 0;
        // System.out.println(Arrays.toString(random));

        // // 중복된값
        // for (int i = 0; i < random.length; i++) {
        // for (int j = i + 1; j < random.length; j++) {
        // if (random[i] == random[j])
        // random[j] = 0;
        // }
        // }

        // System.out.println(Arrays.toString(random));
        // for (int i = 0; i < random.length; i++) {
        // if (random[i] != 0)
        // count++;
        // }
        // int[] wow = new int[count];
        // int me = 0;
        // for (int i = 0; i < random.length; i++) {
        // if (random[i] == 0) {
        // continue;
        // }
        // for (int j = me++; j < wow.length; j++) {
        // wow[j] = random[i];
        // }
        // }
        // System.out.println(Arrays.toString(wow));

        // String str = "ABCDE";
        // char ch = str.charAt(3);
        // System.out.println(ch);
        // for (char s : str.toCharArray()) {
        // System.out.println(s);
        // }

        // exam name 배열의 원소에서 각 문자열의 첫글자를 대문자로 출력하시오.
        // String[] name = new String[3];
        // name[0] = "kim";
        // name[1] = "park";
        // name[2] = "yi";

        // for (String s : name) {
        // System.out.println((char) (s.charAt(0) - 32));
        // // toUperCase() 활용/검색
        // }
    }
}
