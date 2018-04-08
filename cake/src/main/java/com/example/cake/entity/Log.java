package com.example.cake.entity;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.example.cake.utils.DateUtils;

public class Log implements Serializable {

	private static final long serialVersionUID = -2277811821086209502L;

	private Integer id;
	
	private String path;
	
	private String method;
	
	private String ip;
	
	private String protocol;
	
	private String time;
	
	public Log() {}
	
	public Log(HttpServletRequest request) {
		this.path = request.getServletPath();
		this.method = request.getMethod();
		this.protocol = request.getProtocol();
		this.ip = request.getRemoteAddr();
		this.time = DateUtils.getDate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
