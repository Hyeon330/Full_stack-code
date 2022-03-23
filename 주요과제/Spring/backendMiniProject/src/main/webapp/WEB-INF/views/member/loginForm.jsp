<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<link rel="stylesheet" href="${url}/css/member/login.css" type="text/css">
<script src="${url}/js/member/login.js"></script>
<div id="logPage">
    <form id="login-form" method="POST" action="${url}/member/loginOk">
        <div>
            <h1>LOGIN</h1>
            <input type="text" id="userid" name="userid" placeholder="아이디">
            <input type="password" id="userpwd" name="userpwd" placeholder="비밀번호">
            <div id="verify"></div>
            <btn type="submit" id="login" class="btn btn-primary">로그인</div>
            <div><a href="#">비밀번호 찾기</a> | <a href="${url}/signup">회원가입</a> | <a href="${url}/">홈</a></div>
        </div>
    </form>
</div>