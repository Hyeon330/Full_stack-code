package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.ReplyVO;

public interface ReplyService {
	// 댓글 등록
	public int replyWrite(ReplyVO vo);
	// 댓글 목록
	public List<ReplyVO> replyList(int no);
	// 댓글 수정
	public int replyEdit(ReplyVO vo);
	// 댓글 삭제
	public int replyDel(int replyno, String userid);
}
