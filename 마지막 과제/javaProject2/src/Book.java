public class Book {

    int bookPrice;
    String bookNo, bookTitle, bookAuthor, bookYear, bookPublisher;

    Book(String num, String title, String author, int price, String year, String publisher) {
        bookNo = num;
        bookTitle = title;
        bookAuthor = author;
        bookPrice = price;
        bookYear = year;
        bookPublisher = publisher;
    }

    @Override
    public String toString() {
        System.out.println(hangulCharLength(bookPublisher));

        return String.format(
                "%-12s%-" + (17 - hangulCharLength(bookTitle)) + "s%-" + (10 - hangulCharLength(bookAuthor))
                        + "s%-10d%-11s%-" + (16) + "s",
                bookNo, bookTitle,
                bookAuthor, bookPrice,
                bookYear, bookPublisher);
    }

    int hangulCharLength(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((int) str.charAt(i) >= 0xac00 && (int) bookTitle.charAt(i) <= 0xd7a3) {
                count++;
            }
        }
        return count;
    }
}
