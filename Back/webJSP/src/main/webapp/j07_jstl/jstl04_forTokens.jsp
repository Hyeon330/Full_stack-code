<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>forTokens : 특정문자를 기준으로 조각내기</h1>
<ul>
<c:forTokens var="s" items="빨강 주황-노랑,초록/파랑1남 보라" delims=" -,/1">
	<li>${s}</li>
</c:forTokens>
</ul>
</body>
</html>