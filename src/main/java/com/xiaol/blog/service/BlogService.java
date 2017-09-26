package com.xiaol.blog.service;

import java.util.List;

import com.xiaol.blog.common.ArchivePager;
import com.xiaol.blog.common.HomePager;
import com.xiaol.blog.meta.Blog;

/**
 * @Description 博客文章服务类
 * @date 创建时间：2017年2月25日 下午9:36:30
 */
public interface BlogService {

	public int addBlog(Blog blog);

	public int deleteBlogById(int id);

	public int updateBlog(Blog blog);

	public Blog findBlogById(int id);

	public List<Blog> findAllBlog();
	
	public Blog findLastCreateBlog();
	
	public HomePager findHomePager();
	
	public HomePager findHomePager(Integer id);
	
	public ArchivePager findArchivePager();

	public ArchivePager findArchivePager(String date);

}
