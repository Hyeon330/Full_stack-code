const setPageHeight = () => {
    let bodyHeight = window.innerHeight;
    document.querySelector('#page').style.height = bodyHeight+'px';
}
document.addEventListener('DOMContentLoaded', function() {
    setPageHeight();
    window.addEventListener('resize', setPageHeight);

    $('#telNum > input').on('input',function(){
        this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
        if($('#tel1').val().length===3){
            $('#tel2').focus();
        }
        if($('#tel2').val().length===4){
            $('#tel3').focus();
        }
        if($('#tel3').val().length===4){
            $('#email').focus();
        }
    });

    $('#reset').click(function() {
        $('#signin-form').each(function(){
            this.reset();
        });
    });
    $('#toHome').click(function(){
        location.href = 'index.html';
    });
    
    let signupCheckId = false;
    let signupCheckPw = false;
    $('#userid').on('input', function() {
        signupCheckId = false;
        $('#id-verify').html('<span style="color: gray;">영문+숫자 사용(6~20자리)</span>');
    });
    $('#userid-ck').click(function() {
        let userid = $('#userid').val();
        let reg = /^[a-zA-Z]{1}[a-zA-Z0-9]{5,19}$/;
        let ckMsg = "";
        if(userid.length===0){
            ckMsg = '<span style="color: red;">아이디를 입력해주세요.</span>';
        }else if(!reg.test(userid)){
            ckMsg = '<span style="color: red;">아이디 형식이 잘못되었습니다.</span>';
        }else{
            // 백엔드 : if문 아이디 중복 체크...
            ckMsg = '<span style="color: blue;">사용가능한 아이디 입니다.</span>';
            signupCheckId = true;
        }
        $('#id-verify').html(ckMsg);
    });
    let userpw = $('#userpw');
    let userpwCk = $('#userpw-ck');
    let regPw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,20}$/;
    const pwCk = () => {
        signupCheckPw = false;
        let ckMsg = "";
        if(userpw.val().length===0 || userpwCk.val().length===0){
            ckMsg = '<span style="color: gray;">영문+숫자+특수문자 사용(8~20자리)</span>';
        } else if(!regPw.test(userpw.val())){
            ckMsg = '<span style="color: red;">비밀번호 형식이 잘못되었습니다.</span>';
        } else if(userpw.val() != userpwCk.val()){
            ckMsg = '<span style="color: red;">비밀번호가 동일하지 않습니다.</span>';
        } else {
            ckMsg = '<span style="color: blue;">비밀번호가 동일합니다.</span>';
            signupCheckPw = true;
        }
        $('#pw-verify').html(ckMsg);
    };
    userpw.on('input', pwCk);
    userpwCk.on('input', pwCk);

    let emailCk = false;
    let regEmail = /^\w{8,}[@][a-zA-Z]{2,8}[.][a-zA-Z]{2,4}([.][a-zA-Z]{2,4})?$/;
    $('#email').on('input', function(){
        emailCk = false;
        if(regEmail.test($('#email').val())){
            emailCk = true;
        }
        console.log(emailCk);
    });

    $('#signup').click(function(){
        if($('#username').val().length<2 || $('#tel1').val().length<2 || $('#tel2').val().length<3 || $('#tel3').val().length<4 || !emailCk){
            alert("양식에 맞게 값을 전부 채워주세요.");
        }else if(!(signupCheckId && signupCheckPw)) {
            alert("아이디와 비밀번호를 확인 해주세요.");
        } else {
            console.log("hh");
            $('#signin-form').submit();
        }
    });
});