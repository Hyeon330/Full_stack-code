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
    events: event,
    // dateClick: function(info) {
    //     alert('Date ' + info.dateStr);
    // },
    selectable: true,
    // dateClick: function() {
    //     console.log(calendar);
    // },
    // initialDate: '2018-06-01'
});
// calendar.next();    // dayGridMonth일 경우 다음달
// calendar.prev();