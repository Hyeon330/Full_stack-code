public class Test {

    public static void main(String[] args) {

        int[] arr = { 100, 88, 100, 100, 90 };
        float total = 0;
        for (int i : arr) {
            total += i;
        }
        System.out.println(total);
        System.out.println(String.format("%.3f", total / (float) arr.length));
    }
}