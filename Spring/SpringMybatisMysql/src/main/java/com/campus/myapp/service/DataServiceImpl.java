package com.campus.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.campus.myapp.dao.DataDAO;

@Service
public class DataServiceImpl implements DataService {
	@Inject
	DataDAO dao;
}
