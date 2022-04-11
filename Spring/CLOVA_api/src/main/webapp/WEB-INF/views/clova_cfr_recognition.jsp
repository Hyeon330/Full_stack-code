<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- 입력받은 이미지로부터 얼굴을 감지하고 입력된 이미지에서 얼마나 많은 얼굴이 감지되었고
 각 얼굴이 어디에 어떤 크기로 위치하며 어떤 모습을 하고 있는지 반환하는 REST API입니다.
 이미지에서 다음과 같은 정보를 분석합니다. -->
 <script type="text/javascript">
 	$(function() {
 		$('#uploadForm').submit(function(){
 			event.preventDefault();
 			
 			const image = $('#image')[0];
 			if(image.files.length === 0){
 				alert('파일을 선택해주세요.');
 				return;
 			}
 			// 선택한 파일이 있을경우
			var url = 'http://localhost:8050/cfr';
			var data = new FormData($('#uploadForm')[0]);
			$.ajax({
				type: 'post',
				dataType: 'text',
				url: url,
				processData: false,
				contentType: false,
				data: data,
				success: function(result, textStatus){
					console.log('textStatus->', textStatus);
					$('#text').val(result);
				},
				error: function(err){
					console.log('fail...');
					console.log(err);
				}
			});
 		});
 	});
 </script>
</head>
<body>

<form method="post" id="uploadForm" enctype="multipart/form-data">
	이미지 선택 : <input type="file" name="image" id="image"/>
	<button>확인</button>
</form>
<textarea id="text" rows="10" cols="100"></textarea>

</body>
</html>