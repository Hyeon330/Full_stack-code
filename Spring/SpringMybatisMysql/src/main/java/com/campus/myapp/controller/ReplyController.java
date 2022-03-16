package com.campus.myapp.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.myapp.service.ReplyService;
import com.campus.myapp.vo.ReplyVO;

@RestController
@RequestMapping("/reply/")
public class ReplyController {
	@Inject
	ReplyService service;
	
//	@RequestMapping(value="/reply/writeOk", method=RequestMethod.POST)
	@PostMapping("writeOk")
	public int writeOk(ReplyVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logId"));
		return service.replyWrite(vo);
	}
	
	// 댓글목록
	@GetMapping("list")
	public List<ReplyVO> list(int no) {
		return service.replyList(no);
	}
	
	// 댓글수정
	@PostMapping("editOk")
	public int editOk(ReplyVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logId"));
		return service.replyEdit(vo);
		
	}
	
	// 댓글삭제
	@GetMapping("del")
	public int delOk(int replyno, HttpSession session) {
		return service.replyDel(replyno, (String)session.getAttribute("logId"));
	}
}
