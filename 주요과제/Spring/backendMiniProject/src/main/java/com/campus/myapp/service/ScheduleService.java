package com.campus.myapp.service;

import java.util.List;

import com.campus.myapp.vo.ScheduleVO;

public interface ScheduleService {
	public int insertSchedule(ScheduleVO vo);
	public List<ScheduleVO> selectSchedule(String userid, String yearMonth);
}
