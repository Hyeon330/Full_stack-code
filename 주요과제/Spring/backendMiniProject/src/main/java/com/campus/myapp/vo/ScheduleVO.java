package com.campus.myapp.vo;

public class ScheduleVO {
	private int no;
	private String userid;
	private String title;
	private String start;
	private String end;
	
	private String repeats;
	private String repeatCycle;
	private int repeatNum;
	private int repeatNumTimes;
	
	private String color;
	private String place;
	private String text;
	private String pub;
	
	public ScheduleVO(String title, String start, String end, String color, String place, String text) {
		this.title = title;
		this.start = start;
		this.end = end;
		this.color = color;
		this.place = place;
		this.text = text;
	}

	@Override
	public String toString() {
		return "ScheduleVO [getNo()=" + getNo() + ", getUserid()=" + getUserid() + ", getTitle()=" + getTitle()
				+ ", getStart()=" + getStart() + ", getEnd()=" + getEnd() + ", getRepeats()=" + getRepeats()
				+ ", getRepeatCycle()=" + getRepeatCycle() + ", getRepeatNum()=" + getRepeatNum() + ", getColor()="
				+ getColor() + ", getPlace()=" + getPlace() + ", getText()=" + getText() + ", getPub()=" + getPub()
				+ "]";
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getRepeats() {
		if(getRepeatCycle().equals("N")) {
			repeats = getRepeatCycle()+"/0/0";
		} else if(getRepeatCycle().equals("D") || getRepeatCycle().equals("W")) {
			repeats = getRepeatCycle()+"/"+getRepeatNumTimes()+"/"+getRepeatNum();
		}
		else if(getRepeatCycle().equals("M") || getRepeatCycle().equals("Y")) {
			repeats = getRepeatCycle()+"/"+getRepeatNumTimes()+"/0";
		}
		return repeats;
	}
	public void setRepeats(String repeats) {
		String repeatSp[] = repeats.split("/");
		setRepeatCycle(repeatSp[0]);
		setRepeatNumTimes(Integer.parseInt(repeatSp[1]));
		setRepeatNum(Integer.parseInt(repeatSp[2]));
		this.repeats = repeats;
	}
	public String getRepeatCycle() {
		return repeatCycle;
	}
	public void setRepeatCycle(String repeatCycle) {
		this.repeatCycle = repeatCycle;
	}
	public int getRepeatNum() {
		return repeatNum;
	}
	public void setRepeatNum(int repeatNum) {
		this.repeatNum = repeatNum;
	}
	public int getRepeatNumTimes() {
		return repeatNumTimes;
	}
	public void setRepeatNumTimes(int repeatNumTimes) {
		this.repeatNumTimes = repeatNumTimes;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
}
