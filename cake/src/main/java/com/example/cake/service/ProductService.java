package com.example.cake.service;

import com.example.cake.entity.Page;
import com.example.cake.entity.Product;

public interface ProductService {
	
	public Page<Product> list(Integer pageNo,Integer pageSize);

	public int save(Product bean);

	public void delete(Integer[] idArr);
	
	public void delete(int id);

	public Product get(int id);

	public void update(Product bean);
}
