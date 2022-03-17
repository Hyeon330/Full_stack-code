<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
	$(function(){
		CKEDITOR.replace("content");
		
		$("#dataFrm").submit(function(){
			if($("#subject").val()==''){
				alert("제목을 입력하세요!");
				return false;
			}
			if(CKEDITOR.instances.content.getData()==''){
				alert("글 내용을 입력하세요!");
				return false;
			}
			// 첨부파일 선택 개수
			let fileCount = 0;
			if($("#filename1").val()!=''){
				fileCount++;
			}
			if($("#filename2").val()!=''){
				fileCount++;
			}
			if(fileCount<1){
				alert("첨부파일 1개이상 올려주세요");
				return false;
			}
		});
	});
</script>
<style>
#subject{
	width: 100%;
}
</style>
<div calss="container">
	<h1>자료실 글 등록 폼</h1>
	<!-- 파일업로드기능이 있는 폼은 반드시 enctype속성을 명시 해야함 -->
	<form id="dataFrm" method="post" action="${url}/data/writeOk" enctype="multipart/form-data">
		<ul>
			<li>제목</li>
			<li><input type="text" name="subject" id="subject"></li>
			<li>글 내용</li>
			<li><textarea name="content" id="content"></textarea></li>
			<li>첨부파일</li>
			<li>
				<input type="file" name="filename" id="filename1"><br>
				<input type="file" name="filename" id="filename2">
			</li>
			<li><input type="submit" value="파일 등록"></li>
		</ul>
	</form>
</div>
