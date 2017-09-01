package com.fangyuan.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap map) {
		log.info("get login page.");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		log.info("get logout page.");
		return "login";
	}
}
