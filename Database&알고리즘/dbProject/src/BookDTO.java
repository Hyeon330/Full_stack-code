
public class BookDTO {

	private String bookNo, bookTitle, bookAuthor, bookPublisher;
	private int bookYear, bookPrice;

	public BookDTO(String bookNo, String bookTitle, String bookAuthor, int bookYear, int bookPrice,
			String bookPublisher) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookYear = bookYear;
		this.bookPrice = bookPrice;
		this.bookPublisher = bookPublisher;
	}

	public String getBookNo() {
		return bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public int getBookYear() {
		return bookYear;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}
}
