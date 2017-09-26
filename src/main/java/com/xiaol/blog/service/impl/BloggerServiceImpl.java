package com.xiaol.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaol.blog.mapper.BloggerMapper;
import com.xiaol.blog.meta.Blogger;
import com.xiaol.blog.service.BloggerService;

/**
 * @Description TODO
 * @date 创建时间：2017年2月18日 下午6:06:52
 */
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {

	@Resource
	private BloggerMapper bloggerMapper;

	@Override
	public Blogger getByUsername(String username) {
		return bloggerMapper.findByUsername(username);
	}

	@Override
	public int updateAbout(Blogger blogger) {
		return bloggerMapper.updateAbout(blogger);
	}

	@Override
	public Blogger findBlogger() {
		return bloggerMapper.findBlogger();
	}

}
