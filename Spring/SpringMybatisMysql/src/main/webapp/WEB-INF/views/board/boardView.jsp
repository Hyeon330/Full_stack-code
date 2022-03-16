<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	function delCheck() {
		// 사용자가 yes(true), no(false) 선택 가능
		if(confirm("삭제하시겠습니까?")){ // 확인 누를 시
			location.href="/myapp/board/boardDel?no=${vo.no}";
		}
	}
</script>
<div class="container">
	<h1>글내용 보기</h1>
	<ul>
		<li>번호 : ${vo.no }</li>
		<li>작성자 : ${vo.userid }</li>
		<li>작성일 : ${vo.writedate }</li>
		<li>조회수 : ${vo.hit }</li>
		<li>제목 : ${vo.subject }</li>
		<li>글 내용</li>
		<li>${vo.content }</li>
	</ul>
	<div>
		<c:if test="${logId==vo.userid }">
			<a href="/myapp/board/boardEdit?no=${vo.no }">수정</a>
			<a href="javascript:delCheck()">삭제</a>
		</c:if>
	</div>
</div>