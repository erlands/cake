package com.example.cake.dao;

import java.util.List;

import com.example.cake.entity.User;

public interface UserDao {

	public List<User> list();

	public User findByUsername(String username);
}
