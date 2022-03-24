package com.campus.myapp.dao;

import java.util.List;

import com.campus.myapp.vo.ScheduleVO;

public interface ScheduleDAO {
	public int insertSchedule(ScheduleVO vo);
	public List<ScheduleVO> selectSchedule(String userid, String yearMonth);
}
