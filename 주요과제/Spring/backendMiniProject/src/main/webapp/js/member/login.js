$(function() {
	let contextPath = $('#url').val()+"/";
    let login = $('#login');
    let userid = $('#userid');
    let userpwd = $('#userpwd');
    let verify = $('#verify');
    login.click(function() {
        if(userid.val().length === 0){
            verify.html("<strong>아이디</strong>를 입력해 주세요.");
            return
        } else if(userpwd.val().length === 0){
            verify.html("<strong>비밀번호</strong>를 입력해 주세요.");
            return
        } else {
			$.ajax({
				url: contextPath+"member/loginCheck",
				data: "userid="+userid.val()+"&userpwd="+userpwd.val(),
				type: "POST",
				success: function(r){
					console.log(r);
					if(r>0){
						$('#login-form').submit();
					} else {
						verify.html("아이디 또는 비밀번호를 잘못 입력하였습니다.<br>입력하신 내용을 다시 확인해주세요.");
					}
				}
			});
        }
    });
});