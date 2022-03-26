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
    let lastDate = new Date(calendar.getDate().getFullYear(), calendar.getDate().getMonth()+1, 0);
    for(let i = 1; i<=lastDate.getDate(); i++){
        eventOfday[i] = [];
        for(let j = 0; j < events.length; j++){
			let startMonth = Number(events[j].start.substring(5,7));
			let endMonth = Number(events[j].end.substring(5,7));
            let startDay = Number(events[j].start.substring(8));
            let endDay = Number(events[j].end.substring(8)-1);
            if(i>=startDay){
				if(i<=endDay || startMonth != endMonth){
					eventOfday[i].push(events[j]);
				}
            } else if(i<=endDay && startMonth!=endMonth && calendar.getDate().getMonth()+1 == endMonth){
				eventOfday[i].push(events[j]);
			}
        }
    }
    let eventListHTML = "";
    for(let i = 1; i<=lastDate.getDate(); i++){
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
    $(".fc-toolbar-chunk button").click(function(){
		changeMonth();
		/*let servicekey = "ta%2FXbxeYm72epaJuJuLg2HgwFVJBJcs%2F6YaIsJ8LPj4l%2Bmk9dxy1mHxKwIxwEaMLWDQ9k5I18FIY0uEBypuqsw%3D%3D";
		$.ajax({
			url: "http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo",
			data: "solYear=2019&solMonth=08&ServiceKey=ta%2FXbxeYm72epaJuJuLg2HgwFVJBJcs%2F6YaIsJ8LPj4l%2Bmk9dxy1mHxKwIxwEaMLWDQ9k5I18FIY0uEBypuqsw%3D%3D&_type=json",			
			success: function(r){
				console.log(r);
				
			}
		});*/
	});
    // reactive page
	$(window).resize(resizeMain);
	
	// 다이얼로그 오픈
    $('#dialogOpen').click(function() {
        $('#dialog').dialog('open');
    });

    // 다이얼로그값 전체 리셋 함수
    const dialogReset = () => {
        $("#title").val('');
        $("#start").val('');
        $("#end").val('');
        $('#repeatCycle').each(function() {
            $(this).find('option:first-of-type').prop('selected',true);
        });
        $('#repeatCycle + span').html('<input type="hidden" name="repeatNum">');
        $('#pub').prop('checked', false);
        $('#event-87CEEB').prop('checked', true);
        $("#place").val('');
        $("#text").val('');
    };
    
    let startDate = null;
	let endDate = null;
    // 다이얼로그 세팅
    $('#dialog').dialog({
        autoOpen: false, // 실행시 자동열림
        modal: true,
        buttons: {
            등록: function(){
				var regex = RegExp(/^\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/);
				startDate = new Date($("#start").val());
				endDate = new Date($("#end").val());
                if($("#title").val()==''){
					alert("제목을 입력해주세요.");
					$("#title").focus();
				} else if($("#start").val()==''){
					alert("시작날짜를 입력해주세요.");
					$("#start").focus();
				} else if($("#end").val()==''){
					alert("종료날짜를 입력해주세요.");
					$("#end").focus();
				} else if(!regex.test($("#start").val()) || !regex.test($("#end").val())){
					alert("날짜를 올바른 형식으로 입력해주세요.");
				} else if(startDate > endDate){
					alert("종료날짜는 시작날짜보다 커야합니다.");
				} else if($('#repeatCycle').val()!='N' && $('#repeatNum').val()<=0){
					alert("반복단위는 0보다 커야합니다.");
					$('#repeatNum').focus();
				} else {
					$('#scheduleFrom').submit();
					
					/*$.ajax({
						url: contextPath+"schedule/reg",
						data: $('#scheduleFrom').serialize()+"&year="+calendar.getDate().getFullYear()+"&month="+(calendar.getDate().getMonth()+1),
						type: 'POST',
						success: function(result) {
							result.forEach(e => {
								
							});
						}
					});*/
				}
            },
            초기화: dialogReset,
            취소: function(){
                dialogReset();
                $("#dialog").dialog('close');
            }
        }
    });

    // DatePicker 세팅
    $('#start, #end').datepicker({
        dateFormat: 'yy-mm-dd',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년'
    });
    
	$('#start').change(function(){
		startDate = new Date($("#start").val());
		endDate = new Date($("#end").val());
		if(startDate>endDate || $("#end").val()==''){
			$("#end").val($("#start").val());	
		}
	});
	$('#end').change(function(){
		startDate = new Date($("#start").val());
		endDate = new Date($("#end").val());
		if(startDate>endDate){
			$("#start").val($("#end").val());	
		}
	});
    
    $('#repeatCycle').change(function() {
		if($('#repeatCycle').val()=='N'){
			$('#repeatCycle + span').html('<input type="hidden" name="repeatNum">');
		} else {
			$('#repeatCycle + span').html('반복단위 : <input type="text" name="repeatNum" id="repeatNum">');
		}
	});
	
	$('#repeatNum').on('input',function(){
		this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
		if($('#repeatNum').val().length > 3){
			this.value = this.value.substr(0, 3);
		}
	});
});