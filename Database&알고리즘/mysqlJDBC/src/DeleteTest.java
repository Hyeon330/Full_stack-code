import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteTest {

	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement ps = null;

	public DeleteTest() {

	}

	public void start() {
		try {
			// 사원번호를 입력받아 입력받은 사원을 삭제하라
			System.out.print("삭제할 사원 번호 ->");
			int empno = Integer.parseInt(sc.nextLine());
			// 1.
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.
			conn = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "1234");
			// 3.
			String sql = "delete from emp where empno=?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, empno);

			int result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(result + "개 레코드 삭제 완료.");
			} else {
				System.out.println("삭제된 항목이 없습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new DeleteTest().start();
	}

}
