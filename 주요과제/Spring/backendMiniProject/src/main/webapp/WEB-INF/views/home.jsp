<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<link rel="stylesheet" href="${url}/css/home/home.css" type="text/css">
<script src="${url}/js/home.js"></script>
<div id="sidebar">
    <div id="sideTitle">
        <span id="sideTitleName">일정 목록</span>
        <c:if test="${logStatus=='Y'}">
        	<span id="dialogOpen"><i class="bi bi-calendar-plus"></i></span>
        </c:if>
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
	<form id="scheduleFrom" method="POST" action="${url}/schedule/register">
	    <ul>
	        <li><input type="text" id="title" name="title"  placeholder="제목"></li>
	        <li><input type="text" id="start" name="start" placeholder="시작날짜(년-월-일)"></li>
	        <li><input type="text" id="end" name="end" placeholder="종료날짜(년-월-일)"></li>
	        <li>
	            <select name="repeatCycle" id="repeatCycle">
	                <option value="N">반복안함</option>
	                <option value="D">매일반복</option>
	                <option value="W">매주반복</option>
	                <option value="M">매달반복</option>
	                <option value="Y">매년반복</option>
	            </select>
	            <ul></ul>
	        </li>
	        <li id="event-color">
	        	<input type="radio" name="color" id="event-87CEEB" value="87CEEB" checked> <label for="event-87CEEB"></label>
	        	<input type="radio" name="color" id="event-FF0000" value="FF0000"> <label for="event-FF0000"></label>
	        	<input type="radio" name="color" id="event-00FF00" value="00FF00"> <label for="event-00FF00"></label>
	        	<input type="radio" name="color" id="event-0000FF" value="0000FF"> <label for="event-0000FF"></label>
	        	<input type="radio" name="color" id="event-FFA500" value="FFA500"> <label for="event-FFA500"></label>
	        	<input type="radio" name="color" id="event-808080" value="808080"> <label for="event-808080"></label>
	        	<input type="radio" name="color" id="event-800080" value="800080"> <label for="event-800080"></label>
	        	<input type="radio" name="color" id="event-4B0082" value="4B0082"> <label for="event-4B0082"></label>
	        	<input type="radio" name="color" id="event-008000" value="008000"> <label for="event-008000"></label>
	        	<input type="radio" name="color" id="event-778899" value="778899"> <label for="event-778899"></label>
	        </li>
	        <li><input type="text" id="place" name="place" placeholder="장소"></li>
	        <li><input type="text" id="text" name="text" placeholder="메모"></li>
	        <li><label for="pub">Public</label><input type="checkbox" id="pub" name="pub" value="Y"></li>
	    </ul>
    </form>
</div>
