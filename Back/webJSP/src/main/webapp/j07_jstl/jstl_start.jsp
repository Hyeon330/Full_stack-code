<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl : JSP Standard Tag Library</title>
</head>
<body>
<div style="padding: 20px; background-color: #ddd;">
	1. https://tomcat.apache.org/taglibs/standard/ 에서 라이브러리 다운<br>
	
	2. jakarta-taglibs-standard-1.1.2.zip을 압축을 푼 후<br>
	
	3. jstl.jar, standard.jar를 이클립스의 WEB-INF/lib에 복붙
</div>
<ol>
	<li><a href="jstl01_set.jsp">setTag</a></li>
	<li><a href="jstl02_if.jsp?pageNum=5&title=테스트&hotKey=우크라이나">ifTag</a></li>
	<li><a href="jstl03_forEach.jsp">forEach : 반복문</a></li>
	<li><a href="jstl04_forTokens.jsp">forTokens : 문자열쪼개기</a></li>
	<li><a href="jstl05_url.jsp">url : 링크주소</a></li>
	<li><a href="jstl06_choose.jsp?name=hong1&age=21">choose, when, otherwise : 다중 if문</a></li>
	<li><a href="jstl07_redirect.jsp">redirect : 자동페이지 이동</a></li>
</ol>
</body>
</html>