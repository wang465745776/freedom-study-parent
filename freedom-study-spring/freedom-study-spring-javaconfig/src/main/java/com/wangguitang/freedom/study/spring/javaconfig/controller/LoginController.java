package com.wangguitang.freedom.study.spring.javaconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangguitang.freedom.study.spring.javaconfig.entity.PersonBean;

/**
 * 登录服务-Controller
 * @author freedom wang
 * @date 2018年4月17日上午10:22:36
 * @since 1.0.0
 */
@RestController
public class LoginController {

	@Autowired
	private PersonBean personBean;

	/**
	 * 用户登录
	 * @return
	 * @author freedom wang
	 * @date 2018年4月17日上午10:23:31
	 * @since 1.0.0
	 */
	@GetMapping("/login")
	public PersonBean login() {
		return personBean;
	}
}
