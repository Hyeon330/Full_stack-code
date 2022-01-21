import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	private static BookDAO dao = new BookDAO();
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private ArrayList<BookDTO> dtos = null;
	
	public static BookDAO getDAO() {return dao;}
	
	private BookDAO() {}
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/book";
			String uid = "root";
			String upw = "1234";
			return DriverManager.getConnection(url, uid, upw);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("DB접속 실패");
			e.printStackTrace();
		}
		return null;
	}

	public void insertBook(BookDTO bookDTO) {
		conn = getConnection();
		String sql = "insert into book values (?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bookDTO.getBookNo());
			ps.setString(2, bookDTO.getBookTitle());
			ps.setString(3, bookDTO.getBookAuthor());
			ps.setInt(4, bookDTO.getBookYear());
			ps.setInt(5, bookDTO.getBookPrice());
			ps.setString(6, bookDTO.getBookPublisher());
			ps.executeUpdate();
			System.out.println("레코드가 추가되었습니다.");
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(ps != null) try {ps.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn != null) try {conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}
	
	public void selectBook() {
		dtos = new ArrayList<BookDTO>();
		conn = getConnection();
		String sql = "select * from book";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dtos.add(new BookDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
			}
			
			System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n",
					"bookNo","bookTitle","bookAuthor",
					"bookYear","bookPrice","bookPublisher");
			for (BookDTO dto : dtos) {
				System.out.printf("%s\t%s\t%s\t\t%d\t\t%d\t\t%s\n",
						dto.getBookNo(),dto.getBookTitle(), dto.getBookAuthor(), 
						dto.getBookYear(), dto.getBookPrice(), dto.getBookPublisher());
			}
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch (Exception e2) {e2.printStackTrace();}
			if(ps!=null) try {ps.close();} catch (Exception e2) {e2.printStackTrace();}
			if(conn!=null) try {conn.close();} catch (Exception e2) {e2.printStackTrace();}
		}
	}
}
