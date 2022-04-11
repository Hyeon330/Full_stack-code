<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>AI Service API</h1>
	<ol>
		<li><a href="/cfrform">CFR_Recognition</a> : 얼굴감지</li>
		<li><a href="/cfrform2">CFR_Celebrity</a> : 유명인감지</li>
		<li><a href="/voice">Voice</a> : TTS</li>
		<li><a href="/speech">Speech</a> : 입력된 언어와 음성 데이터를 CSR 서버로 전송하고 인식 결과를 텍스트로 변환</li>
		<li><a href="/sentimentform">Sentiment</a> : 텍스트에 담긴 감정(긍정/부정/중립)을 분석해주는 API</li>
		<li><a href="/summaryform">Summary</a> : 문장을 요약해준다.</li>
		<li><a href="/captchaform">CAPTCHA</a> : 이미지를 이용한 인증</li>
	</ol>
</body>
</html>