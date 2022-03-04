<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>forEach 반복문</h1>
<c:set var="dan" value="${8}"/>
<!-- 	   변수       시작      종료      증가 -->
<c:forEach var="i" begin="2" end="9" step="1">
	${dan} * ${i} = ${dan*i}<br>
</c:forEach>

<h2>배열을 이용한 반복문</h2>
<c:set var="arr" value="<%=new int[]{20,34,53,24,12,5,92,41}%>"/>
<!-- 				  items:배열 또는 컬렉션 -->
<c:forEach var="data" items="${arr}">
	[${data}],
</c:forEach>
<h2>컬렉션을 이용한 반복문</h2>
<%
	List<String> lst = new ArrayList<String>();
	lst.add("강남구");
	lst.add("송파구");
	lst.add("관악구");
	lst.add("영등포구");
	lst.add("서대문구");
%>
<c:set var="city" value="<%=lst%>"/>
<ol>
<c:forEach var="v" items="${city}">
	<li>${v}</li>
</c:forEach>
</ol>
<ul>
<c:forEach var="vv" items="<%=lst%>">
	<li>${vv}</li>
</c:forEach>
</ul>
<h2>HashMap의 컬렉션으로 반복문 처리</h2>
<%
	Map<String, String> map = new HashMap<>();
	map.put("userid", "goguma");
	map.put("username", "고구마");
	map.put("tel", "010-1234-5678");
	map.put("addr", "서울시 강남구 역삼동");
%>
<c:set var="info" value="<%=map%>"/>
<ol>
<c:forEach var="vvv" items="${info}">
	<li>key : ${vvv.key}, value : ${vvv.value}</li>
</c:forEach>
</ol>
<ul>
<c:forEach var="vvv" items="<%=map%>">
	<li>key : ${vvv.key}, value : ${vvv.value}</li>
</c:forEach>
</ul>
</body>
</html>