<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
/*리스트*/
.boardList{
	overflow: auto;
}
.boardList li{
	float: left;
	height: 40px;
	line-height: 40px;
	border-bottom: 1px solid #ddd;
	width: 10%;
}
.boardList li:nth-child(6n+3) {
	width: 50%;
	white-space: nowrap; /*줄안바꿈*/
	overflow: hidden; /*넘친 내용 숨기기*/
	text-overflow: ellipsis;/*넘친 내용 있으면 ... 표시*/
}

/*페이징*/
.paging {
	margin: 30px 0px;
	height: 30px;
	overflow: auto;
}
.paging > li{
	float: left;
	padding-right: 30px;
}

/*검색*/
#searchFrm{
	padding: 20px 200px;
}
</style>
<script>
	$(function(){
		$("#searchFrm").submit(function(){
			if($("#searchWord").val()==""){
				alert("검색어를 입력하세요...");
				return false;
			}
		})
		
		// 리스트 체크하기
		$("#checkAll").click(function() {
			$("input[name=check]").prop("checked", $("#checkAll").prop("checked"));
		});
		$("input[name=check]").click(function(){
			let total = $("input[name=check]").length;
			let checked = $("input[name=check]:checked").length;
			
			if(total != checked) $("#checkAll").prop("checked", false);
			else $("#checkAll").prop("checked", true);
		});
		
		// 선택한 레코드 삭제
		$("#multiDel").click(function() {
			if($("input[name=check]:checked").length==0) return false;
			if(!confirm("선택한 레코드를 삭제하시겠습니까?")) return false;
			
			$("#checkFrm").submit();
		});
		
	});
	
</script>
<div class="container">
	<h1>게시판 목록</h1>
	<div><a href="<%=request.getContextPath()%>/board/boardWrite">글쓰기</a></div>
	<div>
		총 레코드 : ${pVO.totalRecord }, ${pVO.totalPage }/${pVO.pageNum }
	</div>
	<button id="multiDel">선택삭제</button>
	<ul class="boardList">
		<li><input type="checkbox" id="checkAll"></li>
		<li>번호</li>
		<li>제목</li>
		<li>글쓴이</li>
		<li>조회수</li>
		<li>등록일</li>
		
		<form method="post" action="${url}/board/recordDel" id="checkFrm">
			<c:forEach var="vo" items="${list}">
				<li><input type="checkbox" name="check" value="${vo.no}"></li>
				<li>${vo.no }</li>
				<li><a href="/myapp/board/boardView?no=${vo.no}">${vo.subject}</a></li>
				<li>${vo.userid }</li>
				<li>${vo.hit }</li>
				<li>${vo.writedate }</li>
			</c:forEach>
		</form>
	</ul>
	
	
	<!-- 페이징 -->
	<ul class="paging">
	
		<!-- 이전 페이지 -->
		<c:if test="${pVO.pageNum<=pVO.onePageCount}">
			<li>prev</li>
		</c:if>
		<c:if test="${pVO.pageNum>pVO.onePageCount}">
			<li><a href="/myapp/board/boardList?pageNum=${pVO.pageNum-pVO.onePageCount}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">prev</a></li>
		</c:if>
		<!-- 페이지 번호 -->
		<c:forEach var="p" begin="${pVO.startPage}" end="${pVO.startPage+pVO.onePageCount-1}">
			<!-- 총 페이지 수 보다 출력할 페이지 번호가 작을 때 -->
			<c:if test="${p<=pVO.totalPage }">
				<c:if test="${p==pVO.pageNum}">
					<li>${p}</li>
				</c:if>
				<c:if test="${p!=pVO.pageNum}">
					<li><a href="/myapp/board/boardList?pageNum=${p}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">${p}</a></li>
				</c:if>
			</c:if>
		</c:forEach>
		<!-- totalPage%startPage<5 -->
		<!-- 다음 페이지 -->
		<c:if test="${pVO.totalPage-pVO.startPage<pVO.onePageCount }">
			<li>next</li>
		</c:if>
		<c:if test="${pVO.totalPage-pVO.startPage>=pVO.onePageCount }">
			<c:if test="${pVO.pageNum+pVO.onePageCount>pVO.totalPage}">
				<li><a href="/myapp/board/boardList?pageNum=${pVO.totalPage}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">next</a></li>
			</c:if>
			<c:if test="${pVO.pageNum+pVO.onePageCount<=pVO.totalPage}">
				<li><a href="/myapp/board/boardList?pageNum=${pVO.pageNum+pVO.onePageCount}<c:if test='${pVO.searchWord!=null}'>&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}</c:if>">next</a></li>
			</c:if>
			
		</c:if>
	</ul>
	<!-- 검색 -->
	<div>
		<form method="get" action="/myapp/board/boardList" id="searchFrm">
			<select name="searchKey">
				<option value="subject">제목</option>
				<option value="content">글내용</option>
				<option value="userid">글쓴이</option>
			</select>
			<input type="text" name="searchWord" id="searchWord">
			<input type="submit" value="검색">
		</form>
	</div>
</div>