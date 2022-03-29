<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
	function del() {
		if(confirm('삭제할까요?')){
			location.href="/board/boardDel?no=${vo.no}";
		}
	}
</script>
<div id="container">
	<h1>글내용보기</h1>
	번호 : ${vo.no}<br>
	글쓴이 : ${vo.userid}<br>
	등록일 : ${vo.writedate}<br>
	제목 : ${vo.subject}<br>
	글내용<br>${vo.content}<br><br>
	
	<a href="/board/boardEdit?no=${vo.no}">수정</a>
	<a href="javascript:del()">삭제</a>
</div>