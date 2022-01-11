public class Magazine extends Book {

    String month;

    Magazine(String num, String title, String author, int price, String year, String publisher, String month) {
        super(num, title, author, price, year, publisher);
        this.month = month;
    }

    @Override
    public String toString() {
        return String.format(super.toString() + "%s", month);
    }
}
