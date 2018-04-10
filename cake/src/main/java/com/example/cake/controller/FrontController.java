package com.example.cake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.cake.entity.Page;
import com.example.cake.entity.Product;
import com.example.cake.service.ProductService;

@Controller
public class FrontController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product/all")
	@ResponseBody
	public Page<Product> all(Integer pageNo,Integer pageSize){
		if(pageNo == null || pageNo < 1) {
			pageNo = 1;
		}
		
		if(pageSize == null || pageSize < 1) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		
		return this.productService.list(pageNo, pageSize);
	}
	
	@RequestMapping("/product/new")
	@ResponseBody
	public Page<Product> newPro(Integer pageNo,Integer pageSize){
		if(pageNo == null || pageNo < 1) {
			pageNo = 1;
		}
		
		if(pageSize == null || pageSize < 1) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		
		return this.productService.newPro(pageNo,pageSize);
	}
	
	private static final int DEFAULT_PAGE_SIZE = 9;
}
