// db에서 현재 달의 이벤트 리스트를 Ajax로 받아오는 함수
let events = [];
let contextPath = $('#url').val()+"/";

const setEvent = () => {
    // back-end event load...
    console.log("event load!");
    $.ajax({
		url: contextPath+"schedule/eventLoad",
		data: "year="+calendar.getDate().getFullYear()+"&month="+(calendar.getDate().getMonth()+1),
		success: function(result){
			console.log(result);
		}
	});
    
    events = [
		{
			title: 'test',
			start: '2022-04-31',
			end: '2022-04-52'
		},
        {
            title: '가족여행',
            start: '2022-02-02',
            end: '2022-02-07',
            color: '#ddd',
            textColor: 'black',
            place: 'hhhh',
            text: 'hehehehehehehe'
        },
        {
            title: '하하하',
            start: '2022-02-04',
            end: '2022-02-11'
        },
        {
            title: '쿠쿠쿠',
            start: '2022-03-04',
            end: '2022-03-04'
        },
        {
            title: '후후후',
            start: '2022-02-14',
            end: '2022-02-20'
        },
        {
            title: '으얅얅앍앍앍',
            start: '2022-02-15',
            end: '2022-02-22',
            color: 'green',
            textColor: 'white',
            place: 'hhhh',
            text: 'hehehehehehehe'
        }
    ];
    calendar.removeAllEvents();
    events.forEach(e => calendar.addEvent(e));
}

var calendarEl = document.getElementById('calendar'); // 태그
var calendar = new FullCalendar.Calendar(calendarEl, {
    initialView: 'dayGridMonth',
    aspectRatio: 1.8,
    windowResizeDelay: 1,
    headerToolbar: {
        start: 'today',
        center: 'title',
        end: 'prevYear,prev,next,nextYear'
    },
    buttonText: {
        today: 'Today'
    },
    titleFormat: {
        year: 'numeric',
        month: 'short'
    },
    events: events,
    // dateClick: function(info) {
    //     alert('Date ' + info.dateStr);
    // },
    selectable: true,
    // dateClick: function() {
    //     console.log(calendar);
    // },
    // initialDate: '2018-06-01'
});