<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#uploadForm").submit(function() {
			event.preventDefault();
			const file = $('#mp3file')[0];
			
			if(file.files.length === 0){
				alert('mp3파일을 선택해주세요.');
			}else {
				var formData = new FormData($('#uploadForm')[0]);
				$.ajax({
					type:'post',
					dataType: 'text',
					url: "/speechRecOk",
					processData: false,
					contentType: false,
					data: formData,
					success: function(result) {
						$('#text').val(result);
					}
				});
			}
			
		});
	});
</script>
</head>
<body>
<form method="post" id="uploadForm" enctype="multipart/form-data">
	언어선택 : 
	<select name='language'>
		<option value="Kor">한국어</option>
		<option value="Jpn">일본어</option>
		<option value="Eng">영어</option>
		<option value="Chn">중국어</option>
	</select>
	mp3 선택 : <input type="file" name="mp3file" id="mp3file"/>
	<button>확인</button>
</form>
<textarea id="text" rows="20" cols="100"></textarea>
</body>
</html>