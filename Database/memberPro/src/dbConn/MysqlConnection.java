package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MysqlConnection {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("����̺� �ε� ����");
		}
	}
	
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	public void getConn() {
		String url = "jdbc:mysql://localhost:3306/mydb";
		String uid = "root";
		String upw = "1234";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
		} catch (Exception e) {
			System.out.println("DB ���� ����");
		}
	}
	
	public void dbClose() {
		try {
			if(conn != null) conn.close();
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
