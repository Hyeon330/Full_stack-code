const resizeMain = () => {
    let headerHeight = Number($('header').css('height').substring(0, $('header').css('height').length-2));
    let sideTitleHeight = Number($('#sideTitle').css('height').substring(0, $('#sideTitle').css('height').length-2));
    let sideMonthHeight = Number($('#sideMonth').css('height').substring(0, $('#sideMonth').css('height').length-2))
    $('#sidebar').css('height', window.innerHeight-Number($('header').css('height').substring(0, $('header').css('height').length-2)));
    $('#sideMain').css('height', window.innerHeight-headerHeight-sideTitleHeight-sideMonthHeight);

    let sidebarWidth = Number($('#sidebar').css('width').substring(0, $('#sidebar').css('width').length-2));
    $('#contents').css('height', window.innerHeight-headerHeight);
    $('#contents').css('width', window.innerWidth-sidebarWidth);
}
$(function() {
    resizeMain();
    $(window).resize(resizeMain);
});