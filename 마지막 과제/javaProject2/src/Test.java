public class Test {
    public static void main(String[] args) {
        String bookTitle = "자바 프로그래밍";

        int count = 0;
        for (int i = 0; i < bookTitle.length(); i++) {
            if ((int) bookTitle.charAt(i) > 0xac00 && (int) bookTitle.charAt(i) < 0xd7a3) {
                count++;
            }
        }

        System.out.println(count);
    }

}
