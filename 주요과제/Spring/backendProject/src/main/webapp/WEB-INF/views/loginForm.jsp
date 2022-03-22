<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<style>
	ul,li{
		margin: 0;
		padding: 0;
		list-style-type: none;
	}
	#log{
	    width: 400px;
	    margin: 0px auto;
	}
	#log > h2 {
	    text-align: center;
	}
	#logFrm > ul > li {
	    float: left;
	    width: 30%;
	}
	#logFrm > ul > li:nth-child(2n){
	    width: 70%;
	}
	#logFrm > ul > li:last-of-type{
	    width: 100%;
	    text-align: center;
	    margin-top: 30px;
	}
</style>
<script>
    $(function(){
    	$("#logFrm").submit(function(){
    		event.preventDefault();
    		let params = $('#logFrm').serialize();
    		$.ajax({
    			url: "loginOk",
    			type: "POST",
    			data: params,
    			success: function(r){
    				if(r=="Y"){
    					alert("login ok");
    				}else {
    					alert("login fail");
    				}
    			}
    		});
    	});
    });
    
</script>
</head>
<body>
<div class="container">
	<div id="log">
	    <h2>로그인</h2>
	    <hr>
	    <form method="post" id="logFrm">
	        <ul>
	            <li>아이디</li>
	            <li><input type="text" name="userid" id="userid"></li>
	            <li>비밀번호</li>
	            <li><input type="password" name="userpwd" id="userpwd"></li>
	            <li><input type="submit" value="로그인">
	                <input type="reset" value="취 소"></li>
	        </ul>
	    </form>
	</div>
</div>
</body>
</html>