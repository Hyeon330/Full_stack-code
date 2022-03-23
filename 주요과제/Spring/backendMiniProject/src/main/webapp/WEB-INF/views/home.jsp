<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	response.setHeader("Access-Control-Allow-Origin", "http://apis.data.go.kr");
	response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
	response.setHeader("Access-Control-Allow-Headers", "origin, x-requested-with, content-type, accept");
	response.setHeader("Access-Control-Max-Age", "86400");
%>
<link rel="stylesheet" href="${url}/css/home/home.css" type="text/css">
<script src="${url}/js/home.js"></script>
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