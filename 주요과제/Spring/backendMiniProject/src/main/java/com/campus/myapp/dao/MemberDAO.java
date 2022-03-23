package com.campus.myapp.dao;

import com.campus.myapp.vo.MemberVO;

public interface MemberDAO {
	public int insertMember(MemberVO vo);
	public int idCheck(String userid);
	public MemberVO loginSelect(String userid, String userpwd);
}
