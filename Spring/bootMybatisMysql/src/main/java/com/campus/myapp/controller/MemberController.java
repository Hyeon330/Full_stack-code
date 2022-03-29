package com.campus.myapp.controller;

import java.net.Socket;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	ResponseEntity<String> entity;
	HttpHeaders headers;
	
	@GetMapping("login")
	public ModelAndView login() {
		mav = new ModelAndView();
		mav.setViewName("/member/loginForm");
		return mav;
	}
	
	@PostMapping("loginOk")
	public ResponseEntity<String> loginOk(MemberVO vo, HttpSession session) {
		headers = new HttpHeaders();
		headers.add("Contents-Type", "text/html;charset=utf-8");
		
		try {
			MemberVO rVo = service.login(vo);
			
			if(rVo==null) throw new Exception();
			
			session.setAttribute("logId", rVo.getUserid());
			session.setAttribute("logName", rVo.getUsername());
			session.setAttribute("logStatus", "Y");
			
			String msg = "<script>location.href='/';</script>";
			
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		} catch (Exception e) { // 로그인 실패
			e.printStackTrace();
			
			String msg = "<script>alert('로그인실패하였습니다.');history.back(-1);</script>";
			
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
}
