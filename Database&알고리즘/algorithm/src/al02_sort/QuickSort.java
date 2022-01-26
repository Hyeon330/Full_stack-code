package al02_sort;

import java.util.Arrays;
import java.util.HashSet;

public class QuickSort {
    final static int ARR_SIZE = 10;

    public static Integer[] randIntArr() {
        HashSet<Integer> set = new HashSet<>(ARR_SIZE);
        while (true) {
            set.add((int) (Math.random() * 99) + 1);
            if (ARR_SIZE == set.size()) {
                break;
            }
        }

        return set.toArray(new Integer[ARR_SIZE]);
    }

    public static void swap(Integer[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void quickSort(Integer[] arr, int left, int right) {
        int pl = left; // 왼쪽부터 검색할 인덱스 위치
        int pr = right; // 오른쪽부터 검색할 인덱스 위치
        int pi = arr[(left + right) / 2]; // 피벗 위치의 값

        do {
            // 피벗기준 왼쪽에서 오른쪽으로 피벗의 값보다 큰 데이터가 있는 index찾기
            while (arr[pl] < pi) {
                pl++;
            }
            // 피벗기준 오른쪽에서 왼쪽으로 이동하며 피벗의 값보다 작은데이터가 있는 index 찾기
            while (arr[pr] > pi) {
                pr--;
            }
            if (pl <= pr) { // pl의 위치 값과, pr위치의 값을 교환한다.
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        // 정렬 후 왼쪽을 재정렬할 재귀호출
        if (left < pr) {
            quickSort(arr, left, pr);
        }
        // 정렬 후 오른쪽 재정렬할 재귀호출
        if (pl < right) {
            quickSort(arr, pl, right);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = randIntArr();

        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}