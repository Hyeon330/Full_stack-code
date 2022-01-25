
public class BookTest {

	public static void main(String[] args) {
		BookDAO dao = BookDAO.getDAO();
		BookDTO dto = new BookDTO("B004", "자바스크립트", "강길동", 2020, 28000, "서울출판사");

		dao.insertBook(dto);
		dao.selectBook();
	}
}