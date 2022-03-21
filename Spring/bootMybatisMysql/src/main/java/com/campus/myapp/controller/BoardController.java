package com.campus.myapp.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.BoardService;

@RestController
@RequestMapping("/board/")
public class BoardController {
	ModelAndView mav;
	
	@Inject
	BoardService service;
	
	@GetMapping("boardList")
	public ModelAndView allSelect() {
		mav = new ModelAndView();
		mav.addObject("bList", service.allSelect());
		mav.setViewName("board/boardList");
		return mav;
	}
}
