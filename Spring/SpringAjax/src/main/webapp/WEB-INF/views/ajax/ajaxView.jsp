<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
	<style type="text/css">
		#resultView{
			padding: 20px;
			border: 1px solid gray;
			background-color: lightblue;
			height: 200px;
			margin: 20px;
		}
		
		.pList, .plist>li{
			margin: 0;
			padding: 0;
			list-style-type: none;
		}
		.pList > li {
			float: left;
			height: 40px;
			line-height: 40px;
			width: 25%;
		}
		.pList > li:nth-child(n+5){
			border-top: 1px solid gray;
		}
	</style>
	<script>
		$(function(){
			// 비동기식으로 서버에 접속하여 문자열 데이터 가져오기
			$("#ajaxString").click(function(){
				let url = "/myapp/ajaxString";
				let params = "num=100&name=홍길동&addr=서울시 강남구 역삼동";
				$.ajax({
					url: url, // 서버의 매핑 주소
					type: 'GET', // type생략시 default GET
					data: params, // 서버로 보낼 데이터
					success: function(result){ // 서버에서 성공적으로 응답을 받으면 실행, 데이터는 매개변수에 담김
						// 서버에서 받은 데이터를 뷰페이지에 표시
						$("#resultView").html(result)
					},
					error: function(error){
						console.log(error.responseText);
					}
				});
			}); // ajaxString
			
			// 비동기식으로 서버에서 vo객체 가져오기
			$("#ajaxObject").on('click', function(){
				var url = "/myapp/ajaxObject";
				var params = "num=200&name=세종대왕";
				$.ajax({
					url: url,
					data: params,
					success: function(result){
						let tag = "<ul>";
						tag += "<li>상품번호 : "+ result.proNo+"</li>";
						tag += "<li>상품명 : "+ result.proName+"</li>";
						tag += "<li>가격 : " + result.price+"</li>";
						tag += "<li>수량 : " + result.cnt+"</li></ul>";
						$("#resultView").html(tag);
					},
					error: function(error){
						console.log(error.responseText);
					}
				});
			});
			// 비동기식으로 List리턴 받기
			$("#ajaxList").click(function(){
				let url = "/myapp/ajaxList";
				$.ajax({
					url: url,
					success: function(result){
						console.log(result);
						// result의 List객체는 java의 ArrayList객체이기 때문에 재가공 해줘야 한다.
						// $(result)로 처리하면 순서대로 접근할 수 있음
						var $result = $(result);
						
						var tag = '<ol class="pList"><li>상품코드</li><li>상품명</li><li>가격</li><li>수량</li>';
						$result.each(function(idx, o){
							tag+='<li>'+o.proNo+'</li>';
							tag+='<li>'+o.proName+'</li>';
							tag+='<li>'+o.price+'</li>';
							tag+='<li>'+o.cnt+'</li>';
						});
						tag+='</ol>';
						
						$("#resultView").html(tag);
					},
					error: function(){
						console.log("전송에러...");
					}
				});
			});
			
			$("#ajaxMap").click(function(){
				var url = "/myapp/ajaxMap";
				$.ajax({
					url: url,
					success: function(result){
						console.log(result);
						var tag = "<ul>";
						tag+= "<li>"+result.p1.proNo+", "+result.p1.proName+", "+result.p1.price+", "+result.p1.cnt+"</li>";
						tag+= "<li>"+result.p3.proNo+", "+result.p3.proName+", "+result.p3.price+", "+result.p3.cnt+"</li>";
						tag+= "<li>"+result.p5.proNo+", "+result.p5.proName+", "+result.p5.price+", "+result.p5.cnt+"</li>";
						
						tag+="</ul>";
						
						$("#resultView").html(tag);
					}
				});
			});
			
			// Json데이터 보내고 받기
			$("#ajaxJson").click(function(){
				var url = "/myapp/ajaxJson";
				var json = {
						no: 555,
						name: '오우오',
						tel: '010-1234-5678'
				};
				$.ajax({
					url: url,
					data: json,
					dataType: 'json',
					success: function(result){
						// 1. 문자열 json으로 변환
						var jsonData1 = JSON.stringify(result);
						// 2. json을 key, value로 변환한다.
						var jsonData2 = JSON.parse(jsonData1);
						
						console.log(jsonData2);
						
						$("#resultView").html("상품번호 : "+jsonData2.proNo+"<br>"+"상품명 : "+jsonData2.proName+"<br>"+"가격 : "+jsonData2.price);
					}, error: function() {
						console.log('ERROR!!!')
					}
				});
			});
			
			/* $("#pFrm").submit(finction(){
				var url = "/myapp/ajaxForm";
				// 폼의 데이터를 json으로 변환
				var params = $("#pFrm").serialize();
				
				$.ajax({
					url: url,
					type: "POST",
					data: params,
					success: function(r){
						$("#resultView").text(r);
					}
				});
			}); */
			
			$("#pFrm").submit(function(){
				event.preventDefault();
				var url = "/myapp/ajaxForm";
				// 폼의 데이터를 json으로 변환
				var params = $("#pFrm").serialize();
				
				$.ajax({
					url: url,
					type: "POST",
					data: params,
					success: function(r){
						$("#resultView").text(r);
					}
				});
			});
		});
	</script>
</head>
<body>
<h1>Ajax로 비동기식 서버 통신</h1>
<button id="ajaxString">ajax(문자열)</button>
<button id="ajaxObject">ajax(Object)</button>
<button id="ajaxList">ajax(List)</button>
<button id="ajaxMap">ajax(Map)</button>
<button id="ajaxJson">ajax(Json)</button>
<hr>
<form method="post" id="pFrm">
	상품명 : <input type="text" name="proName"><br>
	가격 : <input type="text" name="price"><br>
	<input type="submit" value="등록">
</form>
<hr>
<div id="resultView"></div>
</body>
</html>