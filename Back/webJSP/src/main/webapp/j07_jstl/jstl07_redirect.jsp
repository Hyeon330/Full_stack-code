<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1>다른 페이지로 자동이동</h1>
<c:redirect url="/j02_response_jdbc/empForm.jsp">
	<c:param name="no" value="4545"/>
	<c:param name="name" value="김연아"/>
</c:redirect>t