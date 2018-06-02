package com.fangyuan.myschool.config;

import com.fangyuan.myschool.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;


	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
				.authorizeRequests()
                .antMatchers("/oauth/*").permitAll()
				.anyRequest()
				.authenticated();
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

}
