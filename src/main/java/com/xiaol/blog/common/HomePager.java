package com.xiaol.blog.common;

import java.util.List;

import com.xiaol.blog.meta.Blog;

/**
 * @Description home页面数据封装类
 * @date 创建时间：2017年3月1日 下午2:01:06
 */
public class HomePager {
	private Blog blog;// 当前博客
	private Blog preBlog;// 上一篇博客
	private Blog nextBlog;// 下一篇博客
	private List<String> dateGroup;// 博客日期分类侧栏

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Blog getPreBlog() {
		return preBlog;
	}

	public void setPreBlog(Blog preBlog) {
		this.preBlog = preBlog;
	}

	public Blog getNextBlog() {
		return nextBlog;
	}

	public void setNextBlog(Blog nextBlog) {
		this.nextBlog = nextBlog;
	}

	public List<String> getDateGroup() {
		return dateGroup;
	}

	public void setDateGroup(List<String> dateGroup) {
		this.dateGroup = dateGroup;
	}
}
