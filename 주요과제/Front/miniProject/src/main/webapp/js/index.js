// 브라우저 크기 변경에 따른 캘린더 크기 설정 함수
const resizeMain = () => {
    let headerHeight = Number($('#header').css('height').substring(0, $('#header').css('height').length-2));
    let sideTitleHeight = Number($('#sideTitle').css('height').substring(0, $('#sideTitle').css('height').length-2));
    let sideMonthHeight = Number($('#sideMonth').css('height').substring(0, $('#sideMonth').css('height').length-2));
    $('#sidebar').css('height', window.innerHeight-Number($('#header').css('height').substring(0, $('#header').css('height').length-2)));
    $('#sideMain').css('height', window.innerHeight-headerHeight-sideTitleHeight-sideMonthHeight);

    let sidebarWidth = Number($('#sidebar').css('width').substring(0, $('#sidebar').css('width').length-2));
    $('#contentsBack').css('height', window.innerHeight-headerHeight);
    $('#contentsBack').css('width', window.innerWidth-sidebarWidth-17);

    // let calwidth = screen.availWidth-sidebarWidth-380;
    let calwidth = window.innerWidth-sidebarWidth-250;
    $('#contents').css('height', window.innerHeight-headerHeight-60);
    $('#contents').css('width', calwidth);

    calendar.render();
};
// sidebar main 리스트 등록 함수
const setSideMain = () => {
    setEvent();
    let eventOfday = [];
    for(let i = 1; i<=31; i++){
        eventOfday[i] = [];
        for(let j = 0; j < event.length; j++){
            let start = Number(event[j].start.substring(8));
            let end = Number(event[j].end.substring(8)-1)
            if(i>=start && i<=end){
                eventOfday[i].push(event[j]);
            }
        }
    }
    let eventListHTML = "";
    for(let i = 1; i<=31; i++){
        if(eventOfday[i].length!=0){
            eventListHTML +=
            "<div class='dayList'>" +
            "<div class=\"card-header\" data-target=\"#list"+i+"\" data-toggle=\"collapse\">"+i+"일</div>"+
            "<div id=\"list"+i+"\" class=\"collapse\">" +
            // data-parent=\"#listbox\"
            "<ul class=\"eventList\">";
            
            for(let j = 0; j < eventOfday[i].length; j++){
                eventListHTML +=
                "<li style=\"background-color: "+eventOfday[i][j].color+"; color: "+eventOfday[i][j].textColor+"\">"+eventOfday[i][j].title+"</li>";
            }
            eventListHTML +="</ul></div></div>";
        }
    }
    document.querySelector('#listbox').innerHTML = eventListHTML;
}

const changeMonth = () => {
    $("#sideMonth>span").text(calendar.getDate().getFullYear()+"년 " + (calendar.getDate().getMonth() + 1) + "월");
    setSideMain();
};
const nextMonth = () => {
    calendar.next();
    changeMonth();
};
const prevMonth = () => {
    calendar.prev();
    changeMonth();
};

// set myCalendar

document.addEventListener('DOMContentLoaded', function() {
    // pageload
    changeMonth();
    resizeMain();

    // event
    // sidebar main change
    $(".fc-toolbar-chunk button").click(changeMonth);
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

    // 다이얼로그 오픈
    $('#dialogOpen').click(function() {
        $('#dialog').dialog('open');
    });

    // 다이얼로그값 전체 리셋 함수
    const dialogReset = () => {
        $("#event-title").val('');
        $("#start-date").val('');
        $("#end-date").val('');
        $('#repet').each(function() {
            $(this).find('option:first').attr('selected',true);
        });
        $('#public').prop('checked', false);
        $('#event-color').val('#3788D8');
        $("#place").val('');
        $("#memo").val('');
    };

    // 다이얼로그 세팅
    $('#dialog').dialog({
        autoOpen: false, // 실행시 자동열림
        modal: true,
        buttons: {
            등록: function(){
                // ajax 처리
                dialogReset();
                $("#dialog").dialog('close');
            },
            초기화: dialogReset,
            취소: function(){
                dialogReset();
                $("#dialog").dialog('close');
            }
        }
    });

    // DatePicker 세팅
    $('#start-date, #end-date').datepicker({
        dateFormat: 'yy-mm-dd',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
});