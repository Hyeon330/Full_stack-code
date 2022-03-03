<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 에러 발생 시 실행할 페이지일 경우 지시부를 명시 해야함 -->
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>에러 발생!!</h1>
<h2>이미지 클릭 시 홈으로 이동</h2>
<div>
	errorMessage:<%=exception.getMessage() %>
</div>
<a href="../index.jsp"><img src="../img/4.jpg"></a>
</body>
</html>