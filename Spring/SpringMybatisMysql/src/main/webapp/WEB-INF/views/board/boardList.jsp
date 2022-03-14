<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.boardList > li{
	float: left;
	height: 40px;
	line-height: 40px;
	border-bottom: 1px solid #ddd;
	width: 10%;
}
.boardList > li:nth-child(5n+2) {
	width: 60%;
}
</style>
<div class="container">
	<h1>게시판 목록</h1>
	<div><a href="<%=request.getContextPath()%>/board/boardWrite">글쓰기</a></div>
	<ul class="boardList">
		<li>번호</li>
		<li>제목</li>
		<li>글쓴이</li>
		<li>조회수</li>
		<li>등록일</li>
		
		<li>100</li>
		<li><a href="#">자가용...</a></li>
		<li>userid</li>
		<li>0</li>
		<li>03-14 12:50</li>
		
		<li>99</li>
		<li><a href="#">자가용...</a></li>
		<li>userid</li>
		<li>0</li>
		<li>03-14 12:50</li>
		
		<li>98</li>
		<li><a href="#">자가용...</a></li>
		<li>userid</li>
		<li>0</li>
		<li>03-14 12:50</li>
		
		<li>97</li>
		<li><a href="#">자가용...</a></li>
		<li>userid</li>
		<li>0</li>
		<li>03-14 12:50</li>
		
		<li>96</li>
		<li><a href="#">자가용...</a></li>
		<li>userid</li>
		<li>0</li>
		<li>03-14 12:50</li>
	</ul>
</div>