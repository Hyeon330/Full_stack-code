package com.campus.myapp.controller;

import java.time.LocalDate;
import java.time.Period;
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
	
	@GetMapping("eventLoad")
	public List<ScheduleVO> eventLoad(int year, int month, HttpSession session){
		List<ScheduleVO> dbList = service.selectSchedule((String)session.getAttribute("userId"), String.format("%d-%02d", year, month));
		List<ScheduleVO> list = new ArrayList<ScheduleVO>();
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 01);
		for (ScheduleVO vo : dbList) {
			
			if(!vo.getRepeatCycle().equals("N")) {
				System.out.println("not N");
				String[] startDateArr = vo.getStart().split("-");
				String[] endDateArr = vo.getEnd().split("-");
				int startYear = Integer.parseInt(startDateArr[0]);
				int endYear = Integer.parseInt(endDateArr[0]);
				
				int startMonth = Integer.parseInt(startDateArr[1]);
				int endMonth = Integer.parseInt(endDateArr[1]);
				
				int startDay = Integer.parseInt(startDateArr[2]);
				int endDay = Integer.parseInt(endDateArr[2]);
				
				int repeatNum = Integer.parseInt(vo.getRepeatNum());
				if(year>=startYear && month>=startMonth) {
					switch (vo.getRepeatCycle()) {
					case "D":
						if(year==startYear && month==startMonth) {
							System.out.println("D");
							do {
								String start = year+"-"+month+"-"+startDay;
								String end = year+"-"+month+"-"+endDay;
								
								ScheduleVO testVO = new ScheduleVO(vo.getTitle(), start, end, vo.getColor(), vo.getPlace(), vo.getText());
								System.out.println(testVO);
								list.add(testVO);
								
								startDay += Integer.parseInt(vo.getRepeatNum());
								endDay += Integer.parseInt(vo.getRepeatNum());
							} while(startDay>cal.getActualMaximum(Calendar.DATE));
						} else {
							Calendar prevCal = Calendar.getInstance();
							prevCal.set(year, month-2, 1);
							int prevMonthLastDay = prevCal.getActualMaximum(Calendar.DATE);
							Period period = Period.between(LocalDate.of(startYear, startMonth, startDay), LocalDate.of(year, month-2, prevMonthLastDay));
							int startToPrevMonthLastDay = period.getDays();
							int gap = endDay - startDay;
							startDay = repeatNum - startToPrevMonthLastDay % repeatNum;
							endDay = startDay + gap;
							do {
								String start = year+"-"+month+"-"+startDay;
								String end = year+"-"+month+"-"+endDay;
								list.add(new ScheduleVO(vo.getTitle(), start, end, vo.getColor(), vo.getPlace(), vo.getText()));
								startDay += Integer.parseInt(vo.getRepeatNum());
								endDay += Integer.parseInt(vo.getRepeatNum());
							} while(startDay>cal.getActualMaximum(Calendar.DATE));
						}
						break;

					default:
						break;
					}
				}
			} else {
				System.out.println("N");
				System.out.println(vo);
				list.add(vo);
			}
		}
		
		System.out.println(list);
		
		return list;
	}
}
