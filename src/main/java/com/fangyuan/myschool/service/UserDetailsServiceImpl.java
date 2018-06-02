package com.fangyuan.myschool.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

	 @Autowired
	 private UserServiceImpl userService;

	 @Autowired
	 private RoleServiceImpl roleService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		try {
			val grantedAuthorities = new ArrayList<GrantedAuthority>();
			val user = userService.findByPhone(username);
			val roles = roleService.findByUserId(user.getId());
			for (val it : roles) {
				val grantedAuthority = new SimpleGrantedAuthority(it.getName());
				grantedAuthorities.add(grantedAuthority);
			}
			return new User(user.getPhone(), user.getPassword(), grantedAuthorities);
		} catch (Exception e) {
			log.error("Error:  " + e.toString());
			throw new UsernameNotFoundException(e.toString());
		}
	}

}
