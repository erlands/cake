package com.example.cake.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.cake.entity.Product;

public interface ProductDao {

	public List<Product> list(@Param("start")Integer start,@Param("pageSize")Integer pageSize);

	public int save(Product bean);

	public void delete(int id);

	public Product get(int id);

	public void update(Product bean);

	public int count();

	public List<Product> newPro(@Param("start")Integer start,@Param("pageSize")Integer pageSize);

	public int hot(Product product);

	public List<Product> hotList(@Param("start")Integer start,@Param("pageSize")Integer pageSize);

	public int good(Product product);

	public List<Product> goodList(@Param("start")Integer start,@Param("pageSize")Integer pageSize);
}
