package com.example.cake.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cake.dao.LogDao;
import com.example.cake.entity.Log;
import com.example.cake.service.LogService;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao dao;
	@Override
	public int save(Log log) {
		int result = dao.save(log);
		if(result > 0) {
			return log.getId();
		}
		return 0;
	}

}
