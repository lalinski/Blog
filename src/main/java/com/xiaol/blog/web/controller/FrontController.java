package com.xiaol.blog.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.jdbc.log.Log;
import com.xiaol.blog.common.ArchivePager;
import com.xiaol.blog.common.HomePager;
import com.xiaol.blog.common.Result;
import com.xiaol.blog.common.SysCode;
import com.xiaol.blog.meta.Blogger;
import com.xiaol.blog.service.BlogService;
import com.xiaol.blog.service.BloggerService;




/**
 * @Description 前端页面控制器，包括login、projects、archives、tags、about
 * @date 创建时间：2017年2月13日 下午11:01:41
 */
@Controller
@RequestMapping("/")
public class FrontController {

	private static Logger log = LoggerFactory.getLogger(FrontController.class);
	@Resource
	private BlogService blogService;

	@Resource
	private BloggerService bloggerService;

//	@RequestMapping("/dologin")
//	public String doLogin(@ModelAttribute Blogger blogger, HttpServletRequest request, HttpSession session,
//			ModelMap modelMap) {
//		// FIXME 暂时使用session，后期改用shiro
//		
//		Result result = new Result();
//		if (StringUtils.isEmpty(blogger.getUsername()) || StringUtils.isEmpty(blogger.getPassword())) {
//			result.setCode(SysCode.FAIL);
//			result.setMessage("Please check your username or password!");
//			modelMap.addAttribute("loginResult", result);
//			return "forward:/login";
//		}
//		Blogger byUsername = bloggerService.getByUsername(blogger.getUsername());
//		if (byUsername != null && byUsername.getPassword().equals(blogger.getPassword())) {
//			session.setAttribute("blogger", byUsername);
//			return "redirect:/admin/homeView";
//		} else {
//			result.setCode(SysCode.FAIL);
//			result.setMessage("Please check your username and password!");
//			request.setAttribute("loginResult", result);
//			return "forward:/login";
//		}
//	}
	
	@RequestMapping("/dologin")
	public String doLogin(@ModelAttribute Blogger blogger, HttpServletRequest request, HttpSession session,
			ModelMap modelMap) {
	//	System.out.println("username:"+ request.getParameter(username) + "password:" + request.getParameter("password"));
		log.info("username={}", blogger.getUsername());
		log.info("password={}", blogger.getPassword());
		Result result = new Result();
		if (StringUtils.isEmpty(blogger.getUsername()) || StringUtils.isEmpty(blogger.getPassword())) {
			result.setCode(SysCode.FAIL);
			result.setMessage("Please check your username or password!");
			modelMap.addAttribute("loginResult", result);
			return "forward:/login";  //"forward:/login";
		}
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(blogger.getUsername(), blogger.getPassword());
		try {
			// 会调用MyRealm中的doGetAuthenticationInfo方法进行身份认证
			subject.login(token);
			return "redirect:/admin/homeView";
		} catch (AuthenticationException e) {
			result.setCode(SysCode.FAIL);
			result.setMessage("Please check your username and password!");
			request.setAttribute("loginResult", result);
			return "forward:/login";
		}
	}

	/**
	 * @Description: 主页
	 * @author ShawnLin
	 * @date 创建时间：2017年2月19日 下午5:27:16
	 */
	@RequestMapping(path = { "/home", "/" })
	public String home(ModelMap root) {
		HomePager homePager = blogService.findHomePager();
	    
		root.addAttribute("homePager", homePager);
	
		log.info("homepage is equal {}", homePager);
		return "home";
	}

	/**
	 * @Description: 主页获取博文
	 * @author ShawnLin
	 * @date 创建时间：2017年3月1日 下午3:01:53
	 */
	@RequestMapping(path = "/blog/{id}")
	public String getBlog(ModelMap root, @PathVariable int id) {
		HomePager homePager = blogService.findHomePager(id);
		root.addAttribute("homePager", homePager);
		log.info("blog id = {}", homePager.toString());
		return "home";
	}

	/**
	 * @Description: 登录页
	 * @author ShawnLin
	 * @date 创建时间：2017年2月19日 下午5:27:28
	 */
	@RequestMapping("/login")
	public String loginView() {
		return "login";
	}

	@RequestMapping("/about")
	public String about(ModelMap root) {
		Blogger blogger = bloggerService.findBlogger();
		root.addAttribute("blogger", blogger);
		return "about";
	}

	@RequestMapping("/archives")
	public String achives(ModelMap root) {
		ArchivePager archivePager = blogService.findArchivePager();
		root.addAttribute("archivePager", archivePager);
		return "archives";
	}

	@RequestMapping("/archives/{date}")
	public String achivesByDate(ModelMap root, @PathVariable String date) {
		ArchivePager archivePager = blogService.findArchivePager(date);
		root.addAttribute("archivePager", archivePager);
		return "archives";
	}
}
