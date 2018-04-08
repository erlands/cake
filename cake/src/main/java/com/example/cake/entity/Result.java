package com.example.cake.entity;

public class Result {

	private String result;
	
	private String errMsg;
	
	private Object data;
	
	public Result ok(Object data) {
		this.result = "ok";
		this.data = data;
		return this;
	}

	public Result faild(String errMsg) {
		this.result = "error";
		this.errMsg = errMsg;
		return this;
	}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
