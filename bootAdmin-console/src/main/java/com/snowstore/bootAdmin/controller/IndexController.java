package com.snowstore.bootAdmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.snowstore.log.annotation.UserLog;

@Controller
public class IndexController {

	@RequestMapping("login")
	@UserLog(remark="登录页面")
	public String login() {
		return "login";
	}

	@RequestMapping("/")
	public String index() {
		return "customer_list";
	}
}
