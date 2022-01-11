import java.util.ArrayList;

public class BookTest {
    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Magazine> magazines = new ArrayList<Magazine>();

        books.add(new Book("B001", "자바 프로그래밍", "홍길동", 25000, "2021", "멀티출판사"));
        books.add(new Book("B002", "자바스크립트", "이몽룡", 30000, "2020", "서울출판사"));
        books.add(new Book("B003", "HTML/CSS", "성춘향", 18000, "2021", "강남출판사"));
        magazines.add(new Magazine("M001", "자바 월드", "홍길동", 25000, "2021", "멀티출판사", "5"));
        magazines.add(new Magazine("M002", "웹 월드", "이몽룡", 30000, "2020", "서울출판사", "7"));
        magazines.add(new Magazine("M003", "게임 월드", "성춘향", 18000, "2021", "강남출판사", "9"));

        System.out.printf("%-8s%-14s%-8s%-8s%-8s%s\n", "도서번호", "도서명", "저자", "가격", "발행일", "출판사");
        System.out.println("-----------------------------------------------------------------------");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();

        System.out.printf("%-8s%-14s%-8s%-8s%-8s%-10s%s\n", "도서번호", "도서명", "저자", "가격", "발행일", "출판사", "발행월");
        System.out.println("--------------------------------------------------------------------------------");
        for (Magazine magazine : magazines) {
            System.out.println(magazine);
        }

    }
}
