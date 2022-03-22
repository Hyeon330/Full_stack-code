<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<link rel="stylesheet" href="${url}/css/home/home.css" type="text/css">
<script type="text/javascript">
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
}
//sidebar main 리스트 등록 함수
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
    calendar.render();
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

$(function(){
	// pageload
	resizeMain();
	changeMonth();
	
	// event
    // sidebar main change
    $(".fc-toolbar-chunk button").click(changeMonth);
    // reactive page
	$(window).resize(resizeMain);
	
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
</script>
<div id="sidebar">
    <div id="sideTitle">
        <span>일정 목록</span>
        <span id="dialogOpen"><i class="bi bi-calendar-plus"></i></span>
    </div>
    <div id="sideMonth">
        <i class="bi bi-caret-left" onclick="prevMonth()"></i>
        <span>3</span> 
        <i class="bi bi-caret-right" onclick="nextMonth()"></i>
    </div>
    <div id="sideMain">
        <div id="listbox">
        </div>
    </div>
</div>
<!-- 다이얼로그 창 -->
<div id="dialog" title="일정 등록">
    <ul>
        <li><input type="text" id="event-title" name="event-title"  placeholder="제목"></li>
        <li><input type="text" id="start-date" name="start-date" placeholder="시작날짜(년-월-일)"></li>
        <li><input type="text" id="end-date" name="end-date" placeholder="종료날짜(년-월-일)"></li>
        <li>
            <select name="repet" id="repet">
                <option value="N">반복안함</option>
                <option value="D">매일반복</option>
                <option value="W">매주반복</option>
                <option value="M">매달반복</option>
                <option value="Y">매년반복</option>
            </select>
        </li>
        <li><label for="public">Public</label><input type="checkbox" id="public" name="public"></li>
        <li><label for="event-color">이벤트 색상</label><input type="color" id="event-color" name="event-color" value="#3788D8"></li>
        <li><input type="text" id="place" name="place" placeholder="장소"></li>
        <li><input type="text" id="memo" name="memo" placeholder="메모"></li>
    </ul>
</div>