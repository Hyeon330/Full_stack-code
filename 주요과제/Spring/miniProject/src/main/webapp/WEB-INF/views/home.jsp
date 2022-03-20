<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<style>
#sidebar{
	height: 100%;
	width: 210px;
	border-right: 2px solid #ccc;
	overflow: hidden;
}
#sideTitle{
	padding: 0 15px;
	border-bottom: 2px solid #aaa;
	height: 50px;
	line-height: 50px;
}
#sideTitle > span:first-child {
	font-size: 22px;
}
#sideTitle > span:last-child {
	cursor: pointer;
	font-size: 20px;
	position: relative;
	float: right;
	top: 12px;
}
#sideMonth{
	border-bottom: 2px solid #aaa;
	text-align: center;
}
#sideMonth > i {
	margin: 0 10px;
	cursor: pointer;
}
#sideMain {
	width: 100%;
	overflow-x: hidden;
}
#sideMain::-webkit-scrollbar-thumb {
	background-color: #aaa;
	border-radius: 100px;
}
#sideMain::-webkit-scrollbar-track {
	background-color: rgba(0,0,0,0);
}
#listbox{
	width: 200px;
}
</style>
<script type="text/javascript">
$(function(){
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