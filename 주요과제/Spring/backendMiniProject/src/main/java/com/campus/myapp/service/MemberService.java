package com.campus.myapp.service;

import com.campus.myapp.vo.MemberVO;

public interface MemberService {
	public int insertMember(MemberVO vo);
	public int idCheck(String userid);
	public MemberVO loginSelect(String userid, String userpwd);
}
