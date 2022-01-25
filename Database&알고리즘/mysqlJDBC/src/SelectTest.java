import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public SelectTest() {

	}

	public static void start() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// JVM에 설치한 jar파일의 Driver파일의 위치를 올려준다
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB접속 정보들을 입력해 준다.
			String url = "jdbc:mysql://localhost:3306/demo"; // 내 DB경로
			String uid = "root";
			String upw = "1234";

			// 위의 정보들을 이용하여 DB에 접속한다.
			conn = DriverManager.getConnection(url, uid, upw);

			// 쿼리문 작성
			String sql = "select empno, ename, hiredate, sal from emp order by empno";

			// 쿼리문 ps변수에 저장
			ps = conn.prepareStatement(sql);

			// rs변수에 쿼리에 해당하는 응답 저장
			rs = ps.executeQuery();

			System.out.printf("%5s%8s%16s%18s\n", "empno", "ename", "hiredate", "sal");
			while (rs.next()) { // 필드의 첫 번째 행부터 시작하고 현재 행에 값이 있을경우 수행
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String hiredate = rs.getString("hiredate");
				double sal = rs.getDouble("sal");

				System.out.printf("%5d%8s%22s%12.2f\n", empno, ename, hiredate, sal);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB연결 에러 발생");
		} finally { // DB 종료
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
			}
		}
	}

	public static void main(String[] args) {
		start();
	}
}
