package com.example.cake.entity;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable{

	private static final long serialVersionUID = -3984950471358156977L;

	private int total;
	
	private List<T> rows;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
}
