package com.campus.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/data/")
public class DataController {
	
	@GetMapping("dataList")
	public ModelAndView dataList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("data/dataList");
		
		return mav;
	}
}
