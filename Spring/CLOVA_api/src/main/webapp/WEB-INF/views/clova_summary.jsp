<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		$('#btn').click(function() {
			if($('#title').val()=='' || $('#content').val() == ''){
				alert('제목과 글 내용을 입력하세요..');
			}else {
				$.ajax({
					type: 'post',
					dataType: 'text',
					url: '/summaryOk',
					data: {
						title: $('#title').val(),
						content: $("#content").val(),
					},
					success: function(result) {
						$('#resultView').append(result+"<br>");
					}
				});
			}
		});
	});
</script>
</head>
<body>
제목 : <input type="text" id="title" name="title" size="100"><br>
글내용 : <textarea id="content" name="content" rows="20" cols="100"></textarea><br>
<input type="button" id="btn" value="문장요약하기">
<div id="resultView"></div>
</body>
</html>