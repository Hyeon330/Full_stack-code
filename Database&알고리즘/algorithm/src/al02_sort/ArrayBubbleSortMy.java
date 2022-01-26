package al02_sort;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayBubbleSortMy {

    public static void swap(Integer[] arr, int j) {
        int tmp = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = tmp;
    }

    public static void mySort(Integer[] arr) {
        for (int i = arr.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j);
                }
            }
        }
    }

    public static void main(String[] args) {

        final int ARR_SIZE = 30;
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
