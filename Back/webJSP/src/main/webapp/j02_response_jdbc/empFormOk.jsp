<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 에러 발생 시 이동할 페이지 주소 지시부에 명시 -->
<%@page errorPage="../j05_error_page/errorPage.jsp" %>
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
	request.setCharacterEncoding("utf-8");
	// 1. 폼의 데이터를 서버로 가져오기 : request
	int empno = Integer.parseInt(request.getParameter("empno"));
	String ename = request.getParameter("ename");
	int deptno = Integer.parseInt(request.getParameter("deptno"));
	
	// 3. DB연결
	Connection conn = getConnection();
	
	// 4. preparedStatement만들기(sql)
	String sql = "insert into emp(empno, ename, deptno) value(?,?,?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1,empno);
	ps.setString(2,ename);
	ps.setInt(3,deptno);
	
	// 5. 실행
	// insert,delete,update -> excuteUpdate() -> int
	// select -> executeQuery() -> ResultSet
	int cnt = ps.executeUpdate();
	
	// 6. db닫기
	ps.close();
	conn.close();
	
	// 7. 결과에 따른 페이지 이동
	/* if(cnt > 0){ // 등록 성공
		// 페이지 이동
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	} else { // 등록 실패
		// 사원등록폼으로 이동
		response.sendRedirect(request.getContextPath() + "/j02_response_jdbc/empForm.jsp");
	} */
	
	// javascript
	if(cnt>0){
	%>
		<script>
			alert("사원등록되었습니다.");
			location.href="<%=request.getContextPath()%>/index.jsp";
		</script>
	<% } else { %>
		<script>
			alert("사원등록실패");
			history.back();
		</script>
	<% } %>