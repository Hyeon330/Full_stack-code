import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // 이진 검색 트리...\
        int num = 5;
        int[] arr = new int[num];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(5) + 1;
        }
        System.out.println(Arrays.toString(arr));
    }
}