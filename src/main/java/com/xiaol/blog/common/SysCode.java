package com.xiaol.blog.common;

/**
 * @Description 系统常量，包含登录状态码，执行状态码
 * @author Shawn
 * @date 创建时间：2017年2月2日 下午9:19:31
 */
public interface SysCode {

	// 状态码
	/**
	 * 成功
	 */
	public static final int SUCCESS = 200;

	/**
	 * 失败
	 */
	public static final int FAIL = 400;

	/**
	 * 系统错误，请联系管理员
	 */
	public static final int SYS_ERROR = 403;

	/**
	 * 图片保存出错
	 */
	public static final int FILE_SAVE_ERROR = 405;

}
