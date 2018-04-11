package com.example.cake.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cake.dao.CommentDao;
import com.example.cake.entity.Comment;
import com.example.cake.service.CommentService;
import com.example.cake.service.ProductService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao dao;

	@Autowired
	private ProductService productService;
	@Override
	public Integer save(Comment comment) {
		if(comment.getLevel() == 5) {
			productService.good(comment.getPid());
		}
		return this.dao.save(comment);
	}

}
