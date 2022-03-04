package com.campus.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index.do")
public class ServletStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ServletStart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet메소드가 호출됨");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		// /inde.do로 접속한 클라이언트에게 정보 보내기

		
		// 1. 현재페이지의 Content-Type를 셋팅한다.
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. response객체에 쓰기를 하기위해 PrintWriter 객체를 얻어온다.
		PrintWriter pw = response.getWriter();
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>서블릿으로 만든 홈페이지</title>");
		pw.println("<style> h1{color:red;}</style>");
		pw.println("</head><body>");
		
		HttpSession session = request.getSession();
		String logId = (String)session.getAttribute("logId");
		if(logId!=null && !logId.equals("")) {
			pw.println((String)session.getAttribute("logName"));
			pw.println("<a href='/webServlet/login.do?n=1'>로그아웃</a>");
		} else {
			pw.println("<a href='/webServlet/login.do'>로그인</a>");
		}
//		pw.println("<a href='/webServlet/login.do'>로그인</a>");
		pw.println("<div><h1>Servlet Home Page</h1></div>");
		pw.println("<p>이름 : "+name+"<br>");
		pw.println("연락처 : "+tel+"</p>");
		pw.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("doPost메소드가 호출됨");
	}
}
