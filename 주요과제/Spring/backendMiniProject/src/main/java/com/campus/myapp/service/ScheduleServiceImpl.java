package com.campus.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.campus.myapp.dao.ScheduleDAO;
import com.campus.myapp.vo.ScheduleVO;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Inject
	ScheduleDAO dao;

	@Override
	public int insertSchedule(ScheduleVO vo) {
		return dao.insertSchedule(vo);
	}

	@Override
	public List<ScheduleVO> selectSchedule(String userid, String yearMonth) {
		return dao.selectSchedule(userid, yearMonth);
	}
}
