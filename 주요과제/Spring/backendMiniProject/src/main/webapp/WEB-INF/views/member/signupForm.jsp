<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<link rel="stylesheet" href="${url}/css/member/signup.css" type="text/css">
<script src="${url}/js/member/signup.js"></script>
<div id="signupPage">
    <form id="signin-form" method="POST" action="${url}/member/signupOk">
        <div>
            <h1>회원가입</h1>
            <div>
                <input type="text" id="userid" name="userid" placeholder="아이디">
                <btn id="userid-ck" type="button" class="btn-sm btn-secondary">중복확인</btn>
            </div>
            <div id="id-verify"><span style="color: gray;">첫 글자 영문, 숫자 사용(6~20자리)</span></div>
            <input type="password" id="userpwd" name="userpwd" placeholder="비밀번호">
            <input type="password" id="userpwd-ck" name="userpwd-ck" placeholder="비밀번호 확인">
            <div id="pw-verify"><span style="color: gray;">영문+숫자+특수문자 사용(8~20자리)</span></div>
            <input type="text" id="username" name="username" placeholder="이름/닉네임(2~12글자)" maxlength="12" required>
            <div id="telNum">tel : <input type="text" id="tel1" name="tel1" maxlength="3" required> - <input type="text" id="tel2" name="tel2" maxlength="4" required> - <input type="text" id="tel3" name="tel3" maxlength="4" required></div>
            <input type="text" id="email" name="email" placeholder="이메일" required>
            <div>
                <btn id="toHome" type="button" class="btn-sm">홈</btn>
                <btn id="signup" type="button" class="btn-sm btn-secondary">가입</btn>
                <btn id="reset" type="reset" class="btn-sm">초기화</btn>
            </div>
        </div>
    </form>
</div>