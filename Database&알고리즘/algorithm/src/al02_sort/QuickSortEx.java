package al02_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSortEx {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("국어점수의 수 : ");
        int gradeNum = Integer.parseInt(bf.readLine());
        Integer[] gradeArr = new Integer[gradeNum];

        for (int i = 0; i < gradeArr.length; i++) {
            System.out.print("국어점수" + (i + 1) + ":");
            gradeArr[i] = Integer.parseInt(bf.readLine());
        }

        System.out.println();
        QuickSort.quickSort(gradeArr, 0, gradeArr.length - 1);

        for (int i = gradeArr.length - 1; i >= 0; i--) {
            System.out.println((i + 1) + "등" + " : " + gradeArr[i]);
        }
    }
}

/*
 * 국어점수를 입력받아 점수순으로 출력하라.
 * 퀵정렬을 이용하라.
 * 
 * 국어점수의 수 : 5
 * 국어점수1:56
 * 국어점수2:92
 * 국어점수3:95
 * 국어점수4:85
 * 국어점수5:56
 * 
 * 점수순으로 출력
 * 1등 : 95
 * 2등 : 92
 * 3등 : 85
 * 4등 : 56
 * 5등 : 56
 * 
 */