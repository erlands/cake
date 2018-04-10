package com.example.cake.entity;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable{

	private static final long serialVersionUID = -3984950471358156977L;

	private int total;
	
	private int totalPage;
	
	private int pageNo;
	
	private int pageSize;
	
	private int start;
	
	private int end;
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStart() {
		if(start == 0) {
			if(pageNo > 5) {
				start = pageNo -4;
			}else {
				start = 1;
			}
		}
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		if(end == 0) {
			if((getTotalPage()-pageNo)>4) {
				end = pageNo + 4;
			}else {
				end = getTotalPage();
			}
		}
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

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

	public int getTotalPage() {
		if(totalPage == 0) {
			totalPage = total/pageSize;
			if(total%pageSize != 0) {
				totalPage++;
			}
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
