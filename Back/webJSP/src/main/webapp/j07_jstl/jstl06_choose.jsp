<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>choose : swich문, 다중 if문</h1>
<c:choose>
	<c:when test="${param.name=='hong'}">
		당신의 이름은 ${param.name}입니다.<br>
	</c:when>
	<c:when test="${param.age>20}">
		당신의 나이는 20세 이상입니다.
	</c:when>
	<c:otherwise>
		당신의 이름은 hong도 아니고, 20세 이상도 아닙니다.
	</c:otherwise>
</c:choose>
</body>
</html>