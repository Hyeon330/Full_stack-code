package com.campus.myapp.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.ScheduleService;
import com.campus.myapp.vo.ScheduleVO;

@RestController
@RequestMapping("/schedule/")
public class ScheduleController {
	@Inject
	ScheduleService service;
	
	ModelAndView mav;
	
	@PostMapping("register")
	public ModelAndView setSchedule(ScheduleVO vo, HttpSession session) {
		mav = new ModelAndView();
		vo.setUserid((String)session.getAttribute("userId"));
		service.insertSchedule(vo);
		mav.setViewName("redirect:/");
		return mav;
	}
	
//	@PostMapping("reg")
//	public List<ScheduleVO> setSchedule(ScheduleVO vo, int year, int month, HttpSession session) {
//		List<ScheduleVO> list = new ArrayList<ScheduleVO>();
//		Calendar cal = Calendar.getInstance();
//		cal.set(year, month-1, 01);
//		if(!vo.getRepeatCycle().equals("N")) {
//			String[] startDateArr = vo.getStart().split("-");
//			String[] endDateArr = vo.getEnd().split("-");
//			int startYear = Integer.parseInt(startDateArr[0]);
//			int endYear = Integer.parseInt(endDateArr[0]);
//			
//			int startMonth = Integer.parseInt(startDateArr[1]);
//			int endMonth = Integer.parseInt(endDateArr[1]);
//			
//			int startDay = Integer.parseInt(startDateArr[2]);
//			int endDay = Integer.parseInt(endDateArr[2]);
//			
//			int repeatNum = Integer.parseInt(vo.getRepeatNum());
//			if(year>=startYear && month>=startMonth) {
//				switch (vo.getRepeatCycle()) {
//				case "D":
//					if(year==startYear && month==startMonth) {
//						do {
//							String start = String.format("%d-%02d-%02d", year, month, startDay);
//							String end = String.format("%d-%02d-%02d", year, month, endDay+1);
//							
//							ScheduleVO resultVO = new ScheduleVO(vo.getTitle(), start, end, vo.getColor(), vo.getPlace(), vo.getText());
//							resultVO.setRepeats(vo.getRepeats());
//							list.add(resultVO);
//							
//							startDay += Integer.parseInt(vo.getRepeatNum());
//							endDay += Integer.parseInt(vo.getRepeatNum());
//						} while(startDay<cal.getActualMaximum(Calendar.DATE));
//					} else {
//						Calendar prevCal = Calendar.getInstance();
//						prevCal.set(year, month-2, 1);
//						int prevMonthLastDay = prevCal.getActualMaximum(Calendar.DATE);
//						Period period = Period.between(LocalDate.of(startYear, startMonth, startDay), LocalDate.of(year, month-1, prevMonthLastDay));
//						int startToPrevMonthLastDay = period.getDays();
//						int gap = endDay - startDay;
//						startDay = repeatNum - startToPrevMonthLastDay % repeatNum;
//						endDay = startDay + gap;
//						do {
//							String start = String.format("%d-%02d-%02d", year, month, startDay);
//							String end = String.format("%d-%02d-%02d", year, month, endDay+1);
//							
//							ScheduleVO resultVO = new ScheduleVO(vo.getTitle(), start, end, vo.getColor(), vo.getPlace(), vo.getText());
//							resultVO.setRepeats(vo.getRepeats());
//							list.add(resultVO);
//							
//							startDay += Integer.parseInt(vo.getRepeatNum());
//							endDay += Integer.parseInt(vo.getRepeatNum());
//						} while(startDay<cal.getActualMaximum(Calendar.DATE));
//					}
//					break;
//
//				default:
//					break;
//				}
//			}
//		} else {
//			list.add(vo);
//		}
//		return list;
//	}
	
	@GetMapping("eventLoad")
	public List<ScheduleVO> eventLoad(int year, int month, HttpSession session){
		List<ScheduleVO> dbList = service.selectSchedule((String)session.getAttribute("userId"), String.format("%d-%02d", year, month));
		List<ScheduleVO> list = new ArrayList<ScheduleVO>();
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 01);
		
		for (ScheduleVO vo : dbList) {
			String[] startDateArr = vo.getStart().split("-");
			String[] endDateArr = vo.getEnd().split("-");
			int startYear = Integer.parseInt(startDateArr[0]);
			int endYear = Integer.parseInt(endDateArr[0]);
			
			int startMonth = Integer.parseInt(startDateArr[1]);
			int endMonth = Integer.parseInt(endDateArr[1]);
			
			int startDay = Integer.parseInt(startDateArr[2]);
			int endDay = Integer.parseInt(endDateArr[2]) + 1;
			
			if(!vo.getRepeatCycle().equals("N")) {
				if(year>=startYear && month>=startMonth) {
					int repeatNum = Integer.parseInt(vo.getRepeatNum());
					switch (vo.getRepeatCycle()) {
					case "D":	// 일 반복
						repeat(year, month, startYear, startMonth, startDay, endDay, repeatNum, vo, list, cal);
						break;
					case "W":	// 주 반복
						repeatNum *= 7;
						repeat(year, month, startYear, startMonth, startDay, endDay, repeatNum, vo, list, cal);
						break;

					default:
						break;
					}
				}
			} else {
				vo.setEnd(String.format("%d-%02d-%02d", endYear, endMonth, endDay));
				list.add(vo);
			}
		}
		
		return list;
	}
	
	void scheduleSet(int year, int month, int startDay, int endDay, int repeatNum, ScheduleVO vo, List<ScheduleVO> list, Calendar cal) {
		do {
			String start = String.format("%d-%02d-%02d", year, month, startDay);
			String end = String.format("%d-%02d-%02d", year, month, endDay);
			
			ScheduleVO resultVO = new ScheduleVO(vo.getTitle(), start, end, vo.getColor(), vo.getPlace(), vo.getText());
			resultVO.setRepeats(vo.getRepeats());
			list.add(resultVO);
			
			startDay += repeatNum;
			endDay += repeatNum;
		} while(startDay<=cal.getActualMaximum(Calendar.DATE));
	}
	
	void repeat(int year, int month, int startYear, int startMonth, int startDay, int endDay, int repeatNum, ScheduleVO vo, List<ScheduleVO> list, Calendar cal) {
		if(year==startYear && month==startMonth) {	// 반복된 일정이면서 시작일이 현재 보고있는 달 일때
			scheduleSet(year, month, startDay, endDay, repeatNum, vo, list, cal);
		} else {	// 반복된 일정이 현재보고있는 달과 다를 경우
			Calendar prevCal = Calendar.getInstance();
			prevCal.set(year, month-2, 1);
			int prevMonthLastDay = prevCal.getActualMaximum(Calendar.DATE);
			
			int startToPrevMonthLastDay = (int) ChronoUnit.DAYS.between(LocalDate.of(startYear, startMonth, startDay), LocalDate.of(year, month-1, prevMonthLastDay));
			
			int gap = endDay - startDay;
			startDay = repeatNum - startToPrevMonthLastDay % repeatNum;
			endDay = startDay + gap;
			if(startDay != 1) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
				Calendar firstCal = Calendar.getInstance();
				
				firstCal.set(year, month-1, startDay);
				firstCal.add(Calendar.DATE, -repeatNum);
				String firstStart = sdf.format(firstCal.getTime());
				firstCal.add(Calendar.DATE, gap);
				String firstEnd = sdf.format(firstCal.getTime());
				
				ScheduleVO firstVO = new ScheduleVO(vo.getTitle(), firstStart, firstEnd, vo.getColor(), vo.getPlace(), vo.getText());
				firstVO.setRepeats(vo.getRepeats());
				list.add(firstVO);
			}
			scheduleSet(year, month, startDay, endDay, repeatNum, vo, list, cal);
		}
	}
}
