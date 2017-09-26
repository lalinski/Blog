package com.xiaol.blog.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiaol.blog.meta.Blog;

/**
 * @Description TODO
 * @date 创建时间：2017年2月18日 下午6:06:26
 */
@Repository
public interface BlogMapper {

	public int addBlog(Blog blog);

	public int deleteBlogById(int id);

	public int updateBlog(Blog blog);

	public Blog findBlogById(int id);

	public List<Blog> findAllBlog();

	public Blog findLastCreateBlog();

	public Blog findPreBlog(int id);

	public Blog findNextBlog(int id);

	public List<String> findDateGroup();

	public List<Blog> findBlogListByDate(String date);

}
