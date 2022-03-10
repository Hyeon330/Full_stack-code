package com.campus.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.campus.myapp.dao.MemberDAO;
import com.campus.myapp.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject		// Dao를 객체 생성.		@AutoWired
	MemberDAO dao;
	
	@Override
	public int memberInsert(MemberVO vo) {
		return dao.memberInsert(vo);
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return dao.loginCheck(vo);
	}

	@Override
	public MemberVO memberSelect(String userid) {
		return dao.memberSelect(userid);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return dao.memberUpdate(vo);
	}
}
