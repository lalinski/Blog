package com.xiaol.blog.meta;

import java.util.Date;

/**
 * @Description 博客文章实体类
 * @date 创建时间：2017年2月20日 下午1:17:58
 */
public class Blog {
	private int id;
	private String title;// 标题
	private String md;// markdown文本
	private String html;// markdown生成HTML
	private Date date;// 博文编写日期
	private Date updateTime;// 博文最后更新日期

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", md=" + md + ", html=" + html + ", date=" + date
				+ ", updateTime=" + updateTime + "]";
	}

}
