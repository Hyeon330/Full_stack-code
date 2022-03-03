<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 이전페이지에 있는 폼의 데이터를 서버로 가져오기 -->
<%
	// post 방식 전송일 때 request객체에 한글을 utf-8로 세팅 후 정보를 얻어온다
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("username");
	String id = request.getParameter("userid");
	String pw = request.getParameter("userpwd");
	
	// 변수 1개에 여러개의 데이터 전송될 때는 배열로 전송을 한다.
	String[] hobby = request.getParameterValues("hobby");
	String[] interest = request.getParameterValues("interest");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
username : <%=name%><br>
userid : <%=id%><br>
userpw : <%=pw%><br>
hobby : 
<%
	for(int i=0; i<hobby.length; i++){
		%>
			<%= hobby[i]%>
		<%
	}
%>
<br>
interest : <%=Arrays.toString(interest) %>

<h1>request객체에 메소드</h1>
<ol>
<%
	Enumeration<String> paramNames = request.getParameterNames();
	while(paramNames.hasMoreElements()){
		%>
		<li><%= paramNames.nextElement() %></li>
		<%
	}
%>
</ol>
<ul>
	<li> 접속자의 컴퓨터 ip : <%= request.getRemoteAddr() %></li>
	<li> 인코딩 코드값 : <%=request.getCharacterEncoding() %></li>
	<li> contentType : <%=request.getContentType() %></li>
	<li> 전송방식 : <%=request.getMethod() %></li>
	<li> 프로토콜 : <%=request.getProtocol() %></li>
	<li> URI : <%=request.getRequestURI() %></li>
	<li> contextPath : <%=request.getContextPath() %></li>
	<li> serverName : <%=request.getServerName() %></li>
	<li> port : <%=request.getServerPort() %></li>
	<li> 절대주소 : <%=request.getServletContext().getRealPath("/") %></li>
</ul>
</body>
</html>