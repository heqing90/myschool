package com.fangyuan.myschool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Value("${resource.id}")
    private String resourceId;
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

        resources.resourceId(resourceId).stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .anonymous().disable()
                .requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }

}
