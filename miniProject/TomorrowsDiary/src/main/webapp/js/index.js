const resizeMain = () => {
    let headerHeight = Number($('#header').css('height').substring(0, $('#header').css('height').length-2));
    let sideTitleHeight = Number($('#sideTitle').css('height').substring(0, $('#sideTitle').css('height').length-2));
    let sideMonthHeight = Number($('#sideMonth').css('height').substring(0, $('#sideMonth').css('height').length-2))
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

// db에서 현재 달의 이벤트 리스트를 Ajax로 받아오는 함수
const setEvent = () => {
    event = [
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
    console.log("event load!");
}

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
// 위에 코드들은 선로딩

// calendar set

// 예내만 젤 후순위 로딩
document.addEventListener('DOMContentLoaded', function() {
    // load
    changeMonth();
    resizeMain();

    // event
    $(".fc-toolbar-chunk button").click(changeMonth);
    $(window).resize(resizeMain);

    let username = document.querySelector('#userinfo');
    let infoMenu = document.querySelector('#info_menu');
    username.addEventListener('click', function() {
        infoMenu.toggleAttribute('hidden');
    });
})