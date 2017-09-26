package com.xiaol.blog.mapper;

import org.springframework.stereotype.Repository;

import com.xiaol.blog.meta.Blogger;

/**
 * @Description TODO
 * @date 创建时间：2017年2月18日 下午6:06:26
 */
@Repository
public interface BloggerMapper {

	public Blogger findByUsername(String username);

	public Blogger findBlogger();

	public int updateAbout(Blogger blogger);

}
