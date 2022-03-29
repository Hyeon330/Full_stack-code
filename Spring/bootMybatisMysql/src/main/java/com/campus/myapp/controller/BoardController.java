package com.campus.myapp.controller;

import java.nio.charset.Charset;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.campus.myapp.service.BoardService;
import com.campus.myapp.vo.BoardVO;

@RestController
@RequestMapping("/board/")
public class BoardController {
	
	@Inject
	BoardService service;
	
	ModelAndView mav;
	ResponseEntity<String> entity;
	
	@GetMapping("boardList")
	public ModelAndView allSelect() {
		mav = new ModelAndView();
		mav.addObject("bList", service.allSelect());
		mav.setViewName("board/boardList");
		return mav;
	}
	
	@GetMapping("boardWrite")
	public ModelAndView boardWrite() {
		mav = new ModelAndView();
		mav.setViewName("board/boardWrite");
		
		return mav;
	}
	
	@PostMapping("boardWriteOk")
	public ResponseEntity<String> boardWriteOk(BoardVO vo, HttpServletRequest req){
		System.out.println("hh");
		vo.setUserid((String) req.getSession().getAttribute("logId"));
		vo.setIp(req.getRemoteAddr());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		try {
			// 글 등록
			service.boardInsert(vo);
			// 글 목록으로 이동
			String msg = "<script>alert('글이 등록되었습니다.'); location.href='/board/boardList';</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// 등록 실패
			String msg = "<script>alert('글등록에 실패하였습니다.'); location.href='/board/boardwrite';</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
			// 글 등록 폼으로 이동
		}
		return entity;
	}
	
	@GetMapping("boardView")
	public ModelAndView boardView(@RequestParam("no") int no) {
		mav = new ModelAndView();
		mav.addObject("vo", service.boardSelect(no));
		mav.setViewName("board/boardView");
		
		return mav;
	}
	
	// 글 수정
	@GetMapping("boardEdit")
	public ModelAndView boardEdit(int no) {
		mav = new ModelAndView();
		mav.addObject("vo", service.boardSelect(no));
		mav.setViewName("board/boardEdit");
		return mav;
	}
	
	@PostMapping("boardEditOk")
	public ResponseEntity<String> boardEditOk(BoardVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logId"));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=UTF-8");
		try {
			service.boardUpdate(vo);
			
			String msg = "<script>alert('글이 수정되었습니다.'); location.href='/board/boardView?no="+vo.getNo()+"';</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		} catch (Exception e) {
			String msg = "<script>alert('글 수정이 실패하였습니다.'); history.back();</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@GetMapping("boardDel")
	public ModelAndView boardDel(int no, HttpSession session) {
		mav = new ModelAndView();
		
		if(service.boardDelete(no, (String)session.getAttribute("logId")) > 0) mav.setViewName("redirect:boardList");
		else {
			mav.addObject("no", no);
			mav.setViewName("redirect:boardView");
		}
		
		
		
		return mav;
	}
}
