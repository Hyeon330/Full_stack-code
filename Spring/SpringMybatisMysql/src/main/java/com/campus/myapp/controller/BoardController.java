package com.campus.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController  // Controller + ResponseBody
@RequestMapping("/board/")
public class BoardController {
	// /board/boardList
	
	@GetMapping("boardList")
	public ModelAndView boardList() {
		ModelAndView mav = new ModelAndView();
		
		// DB처리
		
		mav.setViewName("board/boardList"); // WEB-INF/views/board/boardList.jsp servlet-context.xml
		
		return mav;
	}
}
