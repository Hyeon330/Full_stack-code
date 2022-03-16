<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	function delCheck() {
		// 사용자가 yes(true), no(false) 선택 가능
		if(confirm("삭제하시겠습니까?")){ // 확인 누를 시
			location.href="/myapp/board/boardDel?no=${vo.no}";
		}
	}
	
	// 댓글----
	$(function(){
		// 댓글 목록을 가져오는 함수
		let replyListAll = () => { // 현재글의 댓글을 모두 가져오기
			let url = "/myapp/reply/list";
			let params = "no=${vo.no}";
			$.ajax({
				url: url,
				data: params,
				success: function(result){
					let $result = $(result);
					
					let tag = "<ul>";
					$result.each(function(i, vo){
						tag += "<li><div>" + vo.userid;
						tag += " ("+vo.writedate+") ";
						
						if(vo.userid=='${logId}'){
							tag += "<input type='button' value='수정'>";
							tag += "<input type='button' value='삭제' title="+vo.replyno+">";
						}
						
						tag += "<br>"+vo.coment+"</div>";
						// 본인글 일때 수정폼이 나와야 함.
						if(vo.userid=='${logId}'){
							tag += "<div style='display:none'><form method='post'>";
							tag += "<input type='hidden' name='replyno' value='"+vo.replyno+"'>";
							tag += "<textarea name='coment' style='width:400px; height:50px;'>"+vo.coment+"</textarea>";
							tag += "<input type='submit' value='수정'>";
							tag += "</form></div>";
						}
						tag += "<hr></li>";
					});
					tag += "</ul>";
					
					$("#replyList").html(tag);
				},
				error: function(e){
					console.log(e.response.text);
				}
			});
		}
		
		// 댓글 등록
		$("#replyFrm").submit(function(){
			event.preventDefault();// form 기본이벤트 제거
			if($("#coment").val()==''){
				alert("댓글을 입력 후 등록하세요.");
				return false;
			} else {
				var params = $("#replyFrm").serialize();	// 폼의 데이터 들이 모두 담김
				
				$.ajax({
					url: '/myapp/reply/writeOk',
					data: params,
					type: 'POST',
					success: function(r) {
						// 폼을 초기화
						$("#coment").val("");
						// 댓글 목록 출력 refresh
						replyListAll();
					},
					error: function(e) {
						console.log(e.responseText);
					}
				});
			}
		});
		// 댓글 수정(수정)버튼 선택시 해당 폼 보여주기
		/* $('#replyList input[value=수정]').on('click', function(){
			$(this).parent().css("display","none"); // 숨기기
			$(this).parent().next().css("display","block");
		}); */
		$(document).on('click', '#replyList input[value=수정]', function(){
			$(this).parent().css("display","none"); // 숨기기
			$(this).parent().next().css("display","block");
		});
		
		// 댓글 수정(DB)
		$(document).on('submit','#replyList form',function(){
			event.preventDefault();
			// 데이터
			let params=$(this).serialize();
			let url='/myapp/reply/editOk';
			$.ajax({
				url: url,
				data: params,
				type: 'POST',
				success: function(result){
					replyListAll();
				},
				error: function(e){
					console.log('수정에러발생');
				}
			});
		});
		
		// 댓글삭제
		$(document).on('click','#replyList input[value=삭제]',function(){
			if(confirm('댓글을 삭제하시겠습니까?')){
				var params = "replyno="+$(this).attr("title");
				$.ajax({
					url: '/myapp/reply/del',
					data: params,
					success: function(r){
						replyListAll();
					},
					error: function(e){
						console.log("댓글삭제에러...");
					}
				});
			}
		});
		
		// 현재글의 댓글
		replyListAll();
	});
</script>
<div class="container">
	<h1>글내용 보기</h1>
	<ul>
		<li>번호 : ${vo.no }</li>
		<li>작성자 : ${vo.userid }</li>
		<li>작성일 : ${vo.writedate }</li>
		<li>조회수 : ${vo.hit }</li>
		<li>제목 : ${vo.subject }</li>
		<li>글 내용</li>
		<li>${vo.content }</li>
	</ul>
	<div>
		<c:if test="${logId==vo.userid }">
			<a href="/myapp/board/boardEdit?no=${vo.no }">수정</a>
			<a href="javascript:delCheck()">삭제</a>
		</c:if>
	</div>
	<hr>
	<!-- 댓글 쓰기 -->
	<c:if test="${logStatus=='Y'}">
		<form method="post" action="" id="replyFrm">
			<input type="hidden" name="no" value="${vo.no}">
			<textarea name="coment" id="coment" style="width: 600px; height: 80px; margin: 0 auto;"></textarea>
			<input type="submit" value="댓글 등록">
		</form>
	</c:if>
	<!-- 댓글 목록 -->
	<div id="replyList"></div>
</div>