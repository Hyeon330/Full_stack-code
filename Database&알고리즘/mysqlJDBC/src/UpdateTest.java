import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateTest {

	Scanner sc = new Scanner(System.in);

	public UpdateTest() {

	}

	public void start() {
		// 사원번호와 급여를 입력받아 해당사원의 급여를 수정하는 프로그램작성
		// 데이터 입력
		System.out.print("수정할 사원번호 = ");
		int empno = sc.nextInt();
		System.out.print("수정할 급여 = ");
		int sal = sc.nextInt();

		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1.드라이브 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. db연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "1234");
			// 3.
			String sql = "update emp set sal=? where empno=?";
			ps = conn.prepareStatement(sql);
			// 3-1.
			ps.setInt(1, sal);
			ps.setInt(2, empno);
			// 4.
			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(result + "개의 레코드가 수정되었습니다.");
			} else {
				System.out.println("수정한 레코드가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					ps.close();
			} catch (Exception e2) {
			}
		}
	}

	public static void main(String[] args) {
		new UpdateTest().start();
	}

}
