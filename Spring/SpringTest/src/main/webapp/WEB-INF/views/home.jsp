<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="js_css/style.css" type="text/css"/>
    <script src="js_css/script.js"></script>
</head>
<body>
<div>
	<h1>
	    re: Hello world!
	</h1>
	<ul>
		<li><a href="/myapp/t1?num=120&name=홍길동">서버에 접속하기1(Get)</a></li>
		<li><a href="/myapp/t2?num=120&name=홍길동">서버에 접속하기2(Get)</a></li>
		<li><a href="/myapp/t3?num=120&name=홍길동">서버에 접속하기3(Get)</a></li>
		<li><a href="/myapp/t4?num=120&name=홍길동">서버에 접속하기4(Get)</a></li>
	</ul>
	<P>  The time on the server is ${serverTime}. </P>
	<p> ${msg }</p>
</div>
<div>
	<h2>GET</h2>
	<form method="get" action="/myapp/form1">
		번호 : <input type="text" name="num"/><br>
		이름 : <input type="text" name="name"/><br>
		<input type="submit" value="서버로 보내기" />
	</form>
	<hr>
	<h2>POST</h2>
	<form method="post" action="/myapp/form2">
		번호 : <input type="text" name="num"/><br>
		이름 : <input type="text" name="name"/><br>
		<input type="submit" value="서버로 보내기" />
	</form>
</div>
<img src="/myapp/img/3.jpg"/>
</body>
</html>