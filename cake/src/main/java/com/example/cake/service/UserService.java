package com.example.cake.service;

import java.util.List;

import com.example.cake.entity.User;

public interface UserService {
	public List<User> list();

	public User findByUsername(String username);
}
