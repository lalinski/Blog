package com.xiaol.blog.web.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.log.Log;
import com.xiaol.blog.meta.Blog;
import com.xiaol.blog.meta.Blogger;
import com.xiaol.blog.service.BlogService;
import com.xiaol.blog.service.BloggerService;

/**
 * @Description 博主控制器，用于发布文章等
 * @date 创建时间：2017年2月12日 下午11:11:06
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger log = LoggerFactory.getLogger(AdminController.class);
	@Resource
	private BlogService blogService;
	@Resource
	private BloggerService bloggerService;

	/**
	 * @Description: 跳转到后台主页
	 * @date 创建时间：2017年2月28日 下午4:46:40
	 */
	@RequestMapping(path = { "/homeView", "/" }, method = RequestMethod.GET)
	public String homeView(ModelMap root) {
		List<Blog> blogList = blogService.findAllBlog();
		root.addAttribute("blogList", blogList);
		return "/admin/home";
	}

	/**
	 * @Description: 跳转到博客添加页
	 * @date 创建时间：2017年2月28日 下午4:46:58
	 */
	@RequestMapping(path = { "/blogAddView" }, method = RequestMethod.GET)
	public String blogAddView() {
		return "/admin/blog_add";
	}
	@RequestMapping(path = { "/blogAddView2" }, method = RequestMethod.GET)
	public String blogAddView2() {
		return "/admin/blog_add2";
	}@RequestMapping(path = { "/blogAddView3" }, method = RequestMethod.GET)
	public String blogAddView3() {
		return "/admin/blog_add3";
	}
	/**
	 * @Description: 添加博客
	 * @date 创建时间：2017年2月28日 下午4:47:26
	 */
	@RequestMapping(path = { "/addBlog" }, method = RequestMethod.POST)
	public String blogAdd(@ModelAttribute Blog blog){
		log.info("received message={}", blog.toString());
		log.info("received message={}", blog);
		blogService.addBlog(blog);
		return "redirect:/admin/homeView";
	}

	/**
	 * @Description: 删除博客
	 * @date 创建时间：2017年2月28日 下午7:34:57
	 */
	@RequestMapping(path = { "/blogDelete" }, method = RequestMethod.POST)
	public String blogDelete(int id) {
		blogService.deleteBlogById(id);
		return "redirect:/admin/homeView";
	}

	/**
	 * @Description: 跳转更新博客页
	 * @date 创建时间：2017年2月28日 下午4:47:38
	 */
	@RequestMapping(path = "/blogUpdateView/{id}")
	public String blogUpdateView(@PathVariable int id, ModelMap root) {
		Blog blog = blogService.findBlogById(id);
		log.info("id={}", id);
		log.info("received message={}", blog.toString());
		root.addAttribute("blog", blog);
		return "/admin/blog_update";
	}

	/**
	 * @Description: 博客更新提交
	 * @date 创建时间：2017年2月28日 下午4:47:56
	 */
	@RequestMapping(path = { "/blogUpdate" }, method = RequestMethod.POST)
	public String blogUpdate(Blog blog) {
		blogService.updateBlog(blog);
		return "redirect:/admin/homeView";
	}

	/**
	 * @Description: 跳转到简历编辑页
	 * @date 创建时间：2017年2月28日 下午4:48:07
	 */
	@RequestMapping(path = { "/aboutView" }, method = RequestMethod.GET)
	public String aboutView(ModelMap root) {
		Blogger blogger = bloggerService.findBlogger();
		root.addAttribute("blogger", blogger);
		return "/admin/about";
	}

	/**
	 * @Description: 提交简历更新
	 * @date 创建时间：2017年2月28日 下午4:48:52
	 */
	@RequestMapping(path = { "/aboutUpdate" }, method = RequestMethod.POST)
	public String aboutUpdate(@ModelAttribute Blogger blogger) {
		bloggerService.updateAbout(blogger);
		return "forward:/about";
	}

	/**
	 * @Description: 退出后台
	 * @date 创建时间：2017年3月1日 上午12:19:10
	 */
	@RequestMapping(path = { "/quit" }, method = RequestMethod.GET)
	public String quit(HttpSession session) {
		/*
		 * 不需要手动清除session，shiro框架会帮我们做。如果手动清除。
		 * 会报错：java.lang.IllegalStateException: getAttribute: Session already
		 * invalidated
		 */
		// session.invalidate();
		return "forward:/home";
	}
	
	@RequestMapping(path = { "/uploadImage" }, method = RequestMethod.POST)
	public void hello(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "editormd-image-file", required = false) MultipartFile attach){
	    try {
	         request.setCharacterEncoding( "utf-8" );
	         response.setHeader( "Content-Type" , "text/html" );
	         String rootPath = request.getSession().getServletContext().getRealPath("/resources/upload/");

	         log.info("servletContext path={}", rootPath);
	          /**
	           * 文件路径不存在则需要创建文件路径
	           */
	         File filePath=new File(rootPath);
	         if(!filePath.exists()){
	             filePath.mkdirs();
	         }
	       
	         //最终文件名
	         File realFile=new File(rootPath+File.separator+attach.getOriginalFilename());
	         FileUtils.copyInputStreamToFile(attach.getInputStream(), realFile);

	         //下面response返回的json格式是editor.md所限制的，规范输出就OK
	         response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"./resources/upload/" 
	             + attach.getOriginalFilename() + "\"}" );
	     } catch (Exception e) {
	         try {
	              response.getWriter().write( "{\"success\":0}" );
	         } catch (IOException e1) {
	             e1.printStackTrace();
	         }
	     }
	 }


}