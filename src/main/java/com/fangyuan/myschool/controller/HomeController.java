package com.fangyuan.myschool.controller;

import java.awt.Dialog.ModalExclusionType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {

	@RequestMapping(value = {"", "/", "/home"})
	public String home(ModelMap map) {
		log.info("get home page.");
		return "home";
	}
}
