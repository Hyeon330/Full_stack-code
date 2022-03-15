package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.BoardVO;
import com.campus.myapp.vo.PagingVO;

public interface BoardService {
	public int boardInsert(BoardVO vo);
	
	public List<BoardVO> boardList(PagingVO pVO);

	public int totalRecord(PagingVO pVO);
	
	public BoardVO boardSelect(int no);
	
	public void hitCount(int no);
}
