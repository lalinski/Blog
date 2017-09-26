package com.xiaol.blog.meta;

import java.io.Serializable;

/**
 * @Description 博主实体类
 * @date 创建时间：2017年2月17日 下午11:03:25
 */
public class Blogger implements Serializable{
	
	private static final long serialVersionUID = -5679157693143238519L;
	
	private int id;
	private String username;// 姓名
	private String password;// 密码
	private String avatar;// 头像
	private String github;
	private String email;
	private String md;// 简历的markdown用于后台编写和修改
	private String html;// 简历的html文本用于页面展示

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMd() {
		return md;
	}

	public void setMd(String md) {
		this.md = md;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHeadPortrait() {
		return avatar;
	}

	public void setHeadPortrait(String avatar) {
		this.avatar = avatar;
	}

}
