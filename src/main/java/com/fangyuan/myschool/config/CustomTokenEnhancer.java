package com.fangyuan.myschool.config;

import lombok.val;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(
            OAuth2AccessToken accessToken,
            OAuth2Authentication authentication) {
        val username = authentication.getUserAuthentication().getName();
        val user = (User)authentication.getUserAuthentication().getPrincipal();
        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("username", username);
        additionalInfo.put("roles", user.getAuthorities());
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
