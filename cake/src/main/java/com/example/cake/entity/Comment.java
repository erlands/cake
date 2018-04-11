package com.example.cake.entity;

import java.io.Serializable;

public class Comment implements Serializable {
	private static final long serialVersionUID = -4869771144415298929L;

	private Integer id;
	
	private Integer pid;
	
	private Integer level;
	
	private String comment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	//预留字段
	/*private String tel;
	
	private String QQ;
	
	private String email;*/
	
	
}
