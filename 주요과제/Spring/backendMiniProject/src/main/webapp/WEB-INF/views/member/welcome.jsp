<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<c:if test="${result>0}">
	<link rel="stylesheet" href="${url}/css/member/welcome.css">
	<div id="welcomePage">
		<div>
		    <h2>환영합니다!</h2>
		    <p>화원가입을 완료했습니다.</p>
		    <p><span id="username">${vo.username}</span>님의 아이디는 <span id="userid">${vo.userid}</span>입니다.</p>
		    <p>로그인을 진행하여 다이어리를 이용하세요!</p>
		    <div>
		    	<a href="${url}/" type="button" class="btn-sm">홈</a>
		    	<a href="${url}/login" type="button" class="btn-sm btn-secondary">로그인</a>
		    </div>
	    </div>
	</div>
</c:if>
<c:if test="${result==null || result==0 }">
	<script>
		alert("회원등록 실패하였습니다.\n입력한 값을 확인해주세요");
		history.go(-1);
	</script>
</c:if>