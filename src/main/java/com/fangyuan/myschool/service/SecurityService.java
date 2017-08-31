package com.fangyuan.myschool.service;

public interface SecurityService {
	
	String findLoggedInUsername();
	
	void autoLogin(String username, String password);
}
