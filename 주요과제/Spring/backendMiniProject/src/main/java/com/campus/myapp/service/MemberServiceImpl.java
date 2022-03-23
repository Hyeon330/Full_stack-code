package com.campus.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.campus.myapp.dao.MemberDAO;
import com.campus.myapp.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	MemberDAO dao;

	@Override
	public int insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public int idCheck(String userid) {
		return dao.idCheck(userid);
	}

	@Override
	public MemberVO loginSelect(String userid, String userpwd) {
		return dao.loginSelect(userid, userpwd);
	}
}
