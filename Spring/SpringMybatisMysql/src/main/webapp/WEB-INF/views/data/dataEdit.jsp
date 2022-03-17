<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
	$(function(){
		CKEDITOR.replace("content");
		// 파일 개수 처리하기위한 변수생성
		let fileCount = ${fileCount};
		
		// 새로 추가되는 첨부파일
		$('#dataFrm b').click(function() {
			$(this).parent().css("display", "none"); // 파일명 숨기기
			$(this).parent().next().attr("name", "delFile"); // 삭제파일 정보 name을 delFile로 변경
			$(this).parent().next().next().attr("type", "file"); // 새로운 파일을 선택할 수 있도록
			// 파일 갯수 줄어들어야 한다.
			
			fileCount--;
		});
		
		
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
	<h1>자료실 글 수정 폼</h1>
	<!-- 파일업로드기능이 있는 폼은 반드시 enctype속성을 명시 해야함 -->
	<form id="dataFrm" method="post" action="${url}/data/editOk" enctype="multipart/form-data">
		<input type="hidden" name="no" value="${vo.no }">
		<ul>
			<li>제목</li>
			<li><input type="text" name="subject" id="subject" value="${vo.subject }"></li>
			<li>글 내용</li>
			<li><textarea name="content" id="content">${vo.content }</textarea></li>
			<li>첨부파일</li>
			<li>
				<!-- 첫번째 첨부파일 -->
				<div>${vo.filename1 } &nbsp; &nbsp; &nbsp; <b>X</b></div>
				<!-- X를 누르면 삭제파일명이 있는 input의 name속성 값을 delFile -->
				<input type="hidden" name="" value="${vo.filename1 }">
				<!-- X를 누르면 파일이 삭제되고 새로운 파일 선택이 선택가능하도록 input박스를 만들어 줌 -->
				<input type="hidden" name="filename" id="filename1">
			</li>
			<li>
				<!-- 두번째 첨부파일 -->
				<c:if test="${vo.filename2!=null && vo.filename2!='' }">
					<div>${vo.filename2 } &nbsp; &nbsp; &nbsp; <b>X</b></div>
					<input type="hidden" name="" value="${vo.filename2 }">
					<input type="hidden" name="filename" id="${vo.filename2 }">
				</c:if>
				<!-- 두번쨰 첨부파일이 없을 때 -->
				<c:if test="${vo.filename2==null || vo.filename2=='' }">
					<input type="file" name="filename" id="filename2">
				</c:if>
			</li>
			<li><input type="submit" value="파일 수정"></li>
		</ul>
	</form>
</div>
