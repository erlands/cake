package com.example.cake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cake.dao.UserDao;
import com.example.cake.entity.User;
import com.example.cake.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public List<User> list() {
		return this.dao.list();
	}

	@Override
	public User findByUsername(String username) {
		return this.dao.findByUsername(username);
	}

}
