package al02_sort;

import java.util.Arrays;
import java.util.Random;

public class ArrayBubbleSort {

    public static void swap(int a[], int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    public static void mySort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) { // j = 9
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                }
            }
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        Random ran = new Random();
        // 데이터 준비
        // 1~100까지의 난수생성하여 크기순으로 정렬(오름차순)

        int arr[] = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(100) + 1; // 0~99
        }

        System.out.println("정렬 전" + Arrays.toString(arr));
        mySort(arr, arr.length);
    }
}
