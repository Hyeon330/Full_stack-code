package com.campus.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.MemberService;
import com.campus.myapp.vo.MemberVO;

@RestController
@RequestMapping("/member/")
public class MemberController {
	@Inject
	MemberService service;
	ModelAndView mav;
	MemberVO vo;
	
	@PostMapping("signupOk")
	public ModelAndView signupOk(MemberVO vo) {
		mav = new ModelAndView();
		mav.addObject("result", service.insertMember(vo));
		mav.addObject("vo", vo);
		mav.setViewName("member/welcome");
		return mav;
	}
	
	@PostMapping("idCheck")
	public int idCheck(String userid) {
		return service.idCheck(userid);
	}
	
	@PostMapping("loginOk")
	public ModelAndView loginOk(String userid, String userpwd, HttpSession session, HttpServletRequest req) {
		mav = new ModelAndView();
		vo = service.loginSelect(userid, userpwd);
		session.setAttribute("userId", vo.getUserid());
		session.setAttribute("userName", vo.getUsername());
		session.setAttribute("logStatus", "Y");
		mav.setViewName("redirect:/");
		
		return mav;
	}
	
	@PostMapping("loginCheck")
	public int loginCheck(String userid, String userpwd) {
		vo = service.loginSelect(userid, userpwd);
		System.out.println(userid+"||"+userpwd);
		System.out.println(vo);
		if(vo!=null) {
			return 1;
		}
		return 0;
	}
}
