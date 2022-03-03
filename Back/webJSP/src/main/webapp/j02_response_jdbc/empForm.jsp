<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%!
	// 2. 드라이브로딩
	// 3. db연결
	public Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/demo","root","1234");		
		}catch(Exception e){
			System.out.println("DB연결 에러 발생...");
			e.printStackTrace();
		}
		return conn;
	}
%>
<%
	// dept테이블의 deptno, dname을 선택한다.
	Connection conn = getConnection();
	String sql = "select deptno, dname from dept order by dname";
	PreparedStatement ps = conn.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/j02_response_jdbc/empFormOk.jsp">
	사원번호 : <input type="text" name="empno"><br>
	사원명 : <input type="text" name="ename"><br>
	부서코드 : 
	<select name="deptno">
		<%while(rs.next()){ %>
		<option value="<%=rs.getInt(1)%>"><%=rs.getString(2) %></option>
		<%} %>
	</select>
	<input type="submit" value="사원등록">
</form>
</body>
</html>
<%
	rs.close();
	ps.close();
	conn.close();
%>