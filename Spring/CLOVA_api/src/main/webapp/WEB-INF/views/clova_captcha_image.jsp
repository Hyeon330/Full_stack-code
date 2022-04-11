 <%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Captcha : 이미지를 이용한 인증하기</h1>
<img src="/captchaImage"><br>
<form action="/captchaCheck" method="post">
	<input type="text" name="userin">
	<input type="submit" value="인증하기">
</form>
</body>
</html>