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
        return String.format("%s\t%s\t%s\t%d\t%s\t%s\t",
                bookNo, bookTitle, bookAuthor, bookPrice, bookYear, bookPublisher);
    }
}
