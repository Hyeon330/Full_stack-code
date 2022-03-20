package com.campus.myapp.dao;

import java.util.List;

import com.campus.myapp.vo.DataVO;

public interface DataDAO {
	public int dataInsert(DataVO vo);
	public List<DataVO> dataSelectAll();
	public DataVO dataView(int no);

	public DataVO getFileName(int no); // 파일명만 선택
	public int dataUpdate(DataVO vo);
	
	public int dataDelete(int no, String userid); // 레코드 삭제
}
