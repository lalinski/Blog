package com.xiaol.blog.common;

/**
 * @Description 返回前台的数据
 * @author
 * @date 创建时间：2017年2月19日 下午5:16:05
 */
public class Result {

	private int code;// 状态码
	private String message;// 信息
	private Object data;// 数据

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return data;
	}

	public void setResult(Object result) {
		this.data = result;
	}

}
