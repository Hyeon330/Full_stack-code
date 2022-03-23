$(function() {
	// 내 정보, 로그아웃 메뉴 표시/숨김
	let userIcon = $('#info i');
	let infoMenu = document.querySelector('#info_menu');
	userIcon.click(function() {
		infoMenu.toggleAttribute('hidden');
	});
	infoMenu.addEventListener('mouseleave', function() {
	    infoMenu.setAttribute('hidden',true);
	});
});