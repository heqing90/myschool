package com.fangyuan.myschool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fangyuan.myschool.domain.User;
import com.fangyuan.myschool.service.SecurityService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {

	@Autowired
	private SecurityService securityService;

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
