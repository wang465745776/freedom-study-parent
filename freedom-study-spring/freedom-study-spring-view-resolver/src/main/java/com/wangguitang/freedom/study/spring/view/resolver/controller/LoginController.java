package com.wangguitang.freedom.study.spring.view.resolver.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 登录服务-Controller
 * @author freedom wang
 * @date 2018年4月17日上午10:22:36
 * @since 1.0.0
 */
@Controller
@Component
public class LoginController {

	/**
	 * 用户登录
	 * @return
	 * @author freedom wang
	 * @date 2018年4月17日上午10:23:31
	 * @since 1.0.0
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
