package com.campus.myapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("n")!=null) {
			// 세션 삭제하고 홈으로 이동
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("/webServlet/index.do");
		}else {
			// 로그인폼
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter pw = response.getWriter();
			
			String html = "";
			html += "<!DOCTYPE html>";
			html += "<html>";
			html += "<head><title>로그인</title>";
			html += "<script>";
			html += "function logFormCheck(){";
			html += "if(document.getElementById('userid').value==''){";
			html += "alert('아이디를 입력하세요...'); return false;}";
			html += "if(document.querySelector('#userpwd').value==''){";
			html += "alert('비밀번호를 입력하세요...'); return false;}";
			html += "return true;}</script></head><body>";
			html += "<h1>로그인</h1>";
			html += "<form method='post' action='"+request.getContextPath()+"/login.do' onsubmit='return logFormCheck()'>";
			html += "아이디 : <input type='text' name='userid' id='userid'/><br>";
			html += "비밀번호 : <input type='password' name='userpwd' id='userpwd'/><br>";
			html += "<input type='submit' value='로그인'/></form></body></html>";
			
			pw.println(html);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// db조회
		String userid = request.getParameter("userid");
		String userpwd = request.getParameter("userpwd");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		try {
			// 1. 드라이브로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. DB연결
			String url = "jdbc:mysql://localhost/campusdb";
			String id = "root";
			String pwd = "1234";
			conn = DriverManager.getConnection(url, id, pwd);
			
			// 3. PreparedStatement 생성
			String sql = "select userid, username from member where userid=? and userpwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, userpwd);
			
			// 4. 실행
			rs = ps.executeQuery();
			if(rs.next()) { // 로그인 성공
				// 세션에 이름과 아이디 저장
				// 세션객체를 request에서 얻어올 수 있다.
				HttpSession session = request.getSession();
				session.setAttribute("logId", rs.getString(1));
				session.setAttribute("logName", rs.getString(2));
				
				pw.println("<script>");
				pw.println("alert('로그인 성공하였습니다. \\n홈페이지로 이동합니다.');");
				pw.println("location.href='/webServlet/index.do';");
				pw.println("</script>");
				
			}else { // 로그인 실패
				pw.println("<script>");
				pw.println("alert('로그인 실패하였습니다.');");
				pw.println("history.back();</script>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// db닫기
			try {if(rs!=null) rs.close();}
			catch (SQLException s) {s.printStackTrace();}
			try {if(ps!=null) ps.close();}
			catch (SQLException s) {s.printStackTrace();}
			try {if(conn!=null) conn.close();}
			catch (SQLException s) {s.printStackTrace();}
		}
	}

}
