const setPageHeight = () => {
    let bodyHeight = window.innerHeight;
    document.querySelector('#page').style.height = bodyHeight+'px';
}
document.addEventListener('DOMContentLoaded', function() {
    setPageHeight();
    window.addEventListener('resize', setPageHeight);

    let login = document.querySelector('#login');
    let userid = document.querySelector('#userid');
    let userpw = document.querySelector('#userpw');
    let verify = document.getElementById('verify');
    login.addEventListener('click', function() {
        let verSetHtml = "";
        if(userid.value.length === 0){
            verSetHtml = "<strong>아이디</strong>를 입력해 주세요.";
        } else if(userpw.value.length === 0){
            verSetHtml = "<strong>비밀번호</strong>를 입력해 주세요.";
        } else {
            // if(백엔드 에서 입력값 검증 후 틀리면){
                verSetHtml = "아이디 또는 비밀번호를 잘못 입력하였습니다.<br>입력하신 내용을 다시 확인해주세요.";
            //}
        }
        if(verSetHtml.length!=0){
            verify.innerHTML = verSetHtml;
            return;
        }
        
        document.getElementById('login-form').submit();
    });
});