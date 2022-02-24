// 브라우저 크기 변경에 따른 캘린더 크기 설정 함수
const resizeMain = () => {
    let headerHeight = Number($('#header').css('height').substring(0, $('#header').css('height').length-2));
    let sideTitleHeight = Number($('#sideTitle').css('height').substring(0, $('#sideTitle').css('height').length-2));
    $('#sidebar').css('height', window.innerHeight-Number($('#header').css('height').substring(0, $('#header').css('height').length-2)));
    $('#sideMain').css('height', window.innerHeight-headerHeight-sideTitleHeight);

    let sidebarWidth = Number($('#sidebar').css('width').substring(0, $('#sidebar').css('width').length-2));
    $('#contentsBack').css('height', window.innerHeight-headerHeight);
    $('#contentsBack').css('width', window.innerWidth-sidebarWidth-17);

    // let calwidth = screen.availWidth-sidebarWidth-380;
    let calwidth = window.innerWidth-sidebarWidth-250;
    $('#contents').css('height', window.innerHeight-headerHeight-60);
    $('#contents').css('width', calwidth);

    calendar.render();
};

// set calendar

// 젤 후순위 로딩
document.addEventListener('DOMContentLoaded', function() {
    // pageload
    resizeMain();

    // event
    // reactive page
    $(window).resize(resizeMain);

    // 내 정보, 로그아웃 메뉴 표시/숨김
    let userinfo = document.querySelector('#userinfo');
    let info = document.querySelector('#info');
    let infoMenu = document.querySelector('#info_menu');
    userinfo.addEventListener('click', function() {
        infoMenu.toggleAttribute('hidden');
    });
    info.addEventListener('mouseleave', function() {
        infoMenu.setAttribute('hidden',true);
    });
});