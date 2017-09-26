package com.xiaol.blog.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.xiaol.blog.meta.Blogger;
import com.xiaol.blog.service.BloggerService;

/**
 * @Description 用于博客主登录认证
 * @date 创建时间：2017年2月17日 下午11:29:36
 */
public class BloggerRealm extends AuthorizingRealm {
	@Resource
	private BloggerService bloggerService;

	/**
	 * 当用户进行访问链接时的授权方法，不需要实现，因为登录就有所有权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * 用户登录的认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		Blogger blogger = bloggerService.getByUsername(username);
		if (blogger != null) {
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(blogger.getUsername(), blogger.getPassword(),
					"BloggerRealm");
			return authcInfo;
		} else {
			return null;
		}
	}

}
