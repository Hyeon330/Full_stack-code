<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
#dataList > li{
	float: left;
	width: 10%;
	height: 40px;
	line-height: 40px;
	border-bottom: 1px solid gray;
}
#dataList > li:nth-child(5n+2){
	width: 60%;
}

/* #dataList>li{
    float:left; width:10%; height:40px; line-height:40px; 
    border-bottom:1px solid gray;
}
#dataList>li:nth-child(5n+2){
    width:60%;
} */
</style>
<div class="container">
	<h1>자료실 목록</h1>
	<a href="#">글쓰기</a>
	<ul id="dataList">
		<li>번호</li>
		<li>제목</li>
		<li>글쓴이</li>
		<li>첨부파일</li>
		<li>날짜</li>
		
		<li>100</li>
		<li>제목123</li>
		<li>goguma</li>
		<li>##</li>
		<li>03-04 15:21</li>
	</ul>
</div>