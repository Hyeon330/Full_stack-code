<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    Hello world!  
</h1>

<P>  The time on the server is serverTime. </P>
</body>
<h1>t1매핑</h1>
<p>
	num : ${num }<br>
	name : ${name }
</p>

<h1>t3매핑(vo)</h1>
<p>
num --> ${vo.num }<br>
name --> ${vo.name }
</p>
</html>