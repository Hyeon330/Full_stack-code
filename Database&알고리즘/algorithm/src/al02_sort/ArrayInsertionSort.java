package al02_sort;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayInsertionSort {

    public static int swap(Integer[] arr, int n) {
        int tmp = arr[n - 1];
        arr[n - 1] = arr[n];
        arr[n] = tmp;

        return tmp;
    }

    public static void mySort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = 0;
            for (j = i; j > 0 && arr[j - 1] > tmp; j--) {
                arr[j] = arr[j - 1];

            }
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        final int ARR_SIZE = 10;
        HashSet<Integer> set = new HashSet<>(ARR_SIZE);
        while (true) {
            set.add((int) (Math.random() * 99) + 1);
            if (ARR_SIZE == set.size()) {
                break;
            }
        }
        Integer[] intarr = set.toArray(new Integer[ARR_SIZE]);

        System.out.println(Arrays.toString(intarr));
        mySort(intarr);
        System.out.println(Arrays.toString(intarr));
    }
}
