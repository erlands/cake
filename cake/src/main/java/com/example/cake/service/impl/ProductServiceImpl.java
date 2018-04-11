package com.example.cake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cake.dao.ProductDao;
import com.example.cake.entity.Page;
import com.example.cake.entity.Product;
import com.example.cake.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public Page<Product> list(Integer pageNo,Integer pageSize) {
		Page<Product> page = new Page<Product>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		int total = this.dao.count();
		page.setTotal(total);
		
		List<Product> list = this.dao.list((pageNo - 1) * pageSize, pageSize);
		page.setRows(list);
		return page;
	}
	
	@Override
	public Page<Product> newPro(Integer pageNo, Integer pageSize) {
		Page<Product> page = new Page<Product>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		int total = this.dao.count();
		page.setTotal(total);
		
		List<Product> list = this.dao.newPro((pageNo - 1) * pageSize, pageSize);
		page.setRows(list);
		return page;
	}

	@Override
	public int save(Product bean) {
		int res = this.dao.save(bean);
		if(res > 0) {
			return bean.getId();
		}
		
		return 0;
	}

	@Override
	public void delete(Integer[] idArr) {
		for (Integer id : idArr) {
			delete(id);
		}
	}

	@Override
	public void delete(int id) {
		this.dao.delete(id);
	}

	@Override
	public Product get(int id) {
		return this.dao.get(id);
	}

	@Override
	public void update(Product bean) {
		this.dao.update(bean);
	}

	@Override
	public Product hot(Integer id) {
		Product product = this.get(id);
		product.setHot(product.getHot()+1);
		this.dao.hot(product);
		return product;
	}

	@Override
	public Page<Product> hotList(Integer pageNo, Integer pageSize) {
		Page<Product> page = new Page<Product>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		int total = this.dao.count();
		page.setTotal(total);
		
		List<Product> list = this.dao.hotList((pageNo - 1) * pageSize, pageSize);
		page.setRows(list);
		return page;
	}

	@Override
	public void good(Integer id) {
		Product product = this.get(id);
		product.setGood(product.getGood()+1);
		this.dao.good(product);
	}

	@Override
	public Page<Product> goodList(Integer pageNo, Integer pageSize) {
		Page<Product> page = new Page<Product>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		int total = this.dao.count();
		page.setTotal(total);
		
		List<Product> list = this.dao.goodList((pageNo - 1) * pageSize, pageSize);
		page.setRows(list);
		return page;
	}
}
