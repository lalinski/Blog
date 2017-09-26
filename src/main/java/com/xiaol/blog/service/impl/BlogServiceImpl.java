package com.xiaol.blog.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaol.blog.common.ArchivePager;
import com.xiaol.blog.common.HomePager;
import com.xiaol.blog.mapper.BlogMapper;
import com.xiaol.blog.meta.Blog;
import com.xiaol.blog.service.BlogService;

/**
 * @Description TODO
 * @date 创建时间：2017年2月27日 下午5:33:05
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

	@Resource
	private BlogMapper blogMapper;

	@Override
	public int addBlog(Blog blog) {
		Date today = new Date();
		blog.setDate(today);
		blog.setUpdateTime(today);
		return blogMapper.addBlog(blog);
	}

	@Override
	public int deleteBlogById(int id) {
		return blogMapper.deleteBlogById(id);
	}

	@Override
	public int updateBlog(Blog blog) {
		Date today = new Date();
		blog.setUpdateTime(today);
		return blogMapper.updateBlog(blog);
	}

	@Override
	public Blog findBlogById(int id) {
		return blogMapper.findBlogById(id);
	}

	@Override
	public List<Blog> findAllBlog() {
		List<Blog> list = blogMapper.findAllBlog();
		if (list.isEmpty()) {
			return null;
		}
		return blogMapper.findAllBlog();
	}

	@Override
	public Blog findLastCreateBlog() {
		return blogMapper.findLastCreateBlog();
	}

	@Override
	public HomePager findHomePager() {
		HomePager homePager = new HomePager();
		Blog blog = blogMapper.findLastCreateBlog();
		Blog preBlog = blogMapper.findPreBlog(blog.getId());
		Blog nextBlog = blogMapper.findNextBlog(blog.getId());
		List<String> dateGroup = blogMapper.findDateGroup();
		homePager.setBlog(blog);
		homePager.setPreBlog(preBlog);
		homePager.setNextBlog(nextBlog);
		homePager.setDateGroup(dateGroup);
		return homePager;
	}

	@Override
	public HomePager findHomePager(Integer id) {
		HomePager homePager = new HomePager();
		Blog blog = blogMapper.findBlogById(id);
		Blog preBlog = blogMapper.findPreBlog(id);
		Blog nextBlog = blogMapper.findNextBlog(id);
		List<String> dateGroup = blogMapper.findDateGroup();
		homePager.setBlog(blog);
		homePager.setPreBlog(preBlog);
		homePager.setNextBlog(nextBlog);
		homePager.setDateGroup(dateGroup);
		return homePager;
	}

	@Override
	public ArchivePager findArchivePager() {
		ArchivePager archivePager = new ArchivePager();
		List<Blog> blogList = blogMapper.findAllBlog();
		archivePager.setBlogList(blogList);
		return archivePager;
	}

	@Override
	public ArchivePager findArchivePager(String date) {
		ArchivePager archivePager = new ArchivePager();
		List<Blog> blogList = blogMapper.findBlogListByDate(date);
		archivePager.setBlogList(blogList);
		return archivePager;
	}

}
