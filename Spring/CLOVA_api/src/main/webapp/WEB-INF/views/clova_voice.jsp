<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(() => {
		var audioURL = null;
		var audio = null;
		$("#speakerBtn").click(() => {
			// 비동기식 처리를 할수 있는 객체
			let xhr = new XMLHttpRequest();
			
			// 응답받은 데이터의 데이터타입설정
			xhr.responseType='blob';
			//서버에서 응답 받으면
			xhr.onload = function() {
				audioURL = URL.createObjectURL(this.response);
				audio = new Audio();
				audio.src = audioURL;
				audio.play();
			}
			
			// 서버에 접속하기
			//     전송방식, 매핑주소
			xhr.open('post', 'http://localhost:8050/voiceOk');
			xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
			xhr.send("text="+$('#text').val()); // 서버로 보낼 정보(text=보낼문자열)
		});
		$('#stopBtn').click(function () {
			audio.pause();
			audio.currentTime = 0;
		});
	});
</script>
</head>
<body>
<h1>CLOVA VOICE</h1>
<textarea rows="20" cols="100" id="text"></textarea>
<input type="button" value="스피커" id="speakerBtn">
<input type="button" value="정지" id="stopBtn">
</body>
</html>