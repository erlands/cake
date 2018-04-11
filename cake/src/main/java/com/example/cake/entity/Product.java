package com.example.cake.entity;

import java.io.Serializable;

import com.example.cake.utils.DateUtils;

public class Product implements Serializable {

	private static final long serialVersionUID = -8891703408633774393L;

	private Integer id;
	
	private String proName;
	
	private String proDesc;
	
	private Float price;
	
	private String createTime;
	
	private String img;
	
	private Integer hot;
	
	private Integer good;
	
	public Product init() {
		this.hot = 0;
		this.good = 0;
		this.createTime = DateUtils.getDate();
		return this;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Integer getGood() {
		return good;
	}

	public void setGood(Integer good) {
		this.good = good;
	}
	
	
}
