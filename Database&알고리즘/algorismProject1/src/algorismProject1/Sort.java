package algorismProject1;
public class Sort {
	
	public static void quickSort(int[] arr) {
    	int lEnd = 0;
		int rEnd = arr.length - 1;
        quickSort(arr, lEnd, rEnd);
    }

    private static void quickSort(int[] arr, int lEnd, int rEnd) {
        int pl = lEnd;
        int pr = rEnd;
        int pv = arr[(lEnd + rEnd) / 2];

        while (pl < pr) {
            while (arr[pl] > pv) pl++;
            while (arr[pr] < pv) pr--;
            if (pl <= pr) swap(arr, pl++, pr--);
        }
        
        if (lEnd < pr) quickSort(arr, lEnd, pr);
        if (pl < rEnd) quickSort(arr, pl, rEnd);
    }
    
    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
