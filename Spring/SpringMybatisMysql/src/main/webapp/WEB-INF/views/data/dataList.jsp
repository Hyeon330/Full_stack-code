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
	<a href="${url}/data/write">글쓰기</a>
	<ul id="dataList">
		<li>번호</li>
		<li>제목</li>
		<li>글쓴이</li>
		<li>첨부파일</li>
		<li>날짜</li>
		
		<c:forEach var="vo" items="${list}">
			<li>${vo.no }</li>
			<li><a href="${url}/data/view?no=${vo.no}">${vo.subject }</a></li>
			<li>${vo.userid}</li>
			<li>
				<!-- 첫번쨰 첨부파일 -->
				<a href="${url}/upload/${vo.filename1}" download><img src="${url}/img/disk.png" title="${vo.filename1}"></a>
				<!-- 두번째 첨부파일 -->
				<c:if test="${vo.filename2!=null && vo.filename2!=''}">
					<a href="${url}/upload/${vo.filename2}" download><img src="${url}/img/disk.png" title="${vo.filename2}"></a>
				</c:if>
			</li>
			<li>${vo.writedate}</li>
		</c:forEach>
	</ul>
</div>