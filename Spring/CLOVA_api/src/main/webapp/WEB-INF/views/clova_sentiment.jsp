<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		$('#senti').click(function() {
			if($('#content').val() == ''){
				alert("글을 입력 후 확인하세요.");
			}else {
				var url = '/sentimentOk';
				$.ajax({
					type: 'post',
					dataType: 'text',
					url: url,
					data: {
						content : $('#content').val()
					},
					success: function(result) {
						console.log(result);
						$('#sentimentResult').append(result+'<br>');
					},
					error: function(e) {
						console.log(e.responseText);
					}
				});
			}
		});
	});
</script>
</head>
<body>
<h1>Sentiment : 텍스트에 담긴 감정(긍정/부정/중립)을 분석해주는 API</h1>
<textarea rows="10" cols="100" id="content"></textarea><br>
<button id="senti">감정판단</button>
<pre>
neutral: 중립
positive: 긍정
negative: 부정
</pre>
<div id='sentimentResult' style="background-color: #ddd;"></div>
</body>
</html>