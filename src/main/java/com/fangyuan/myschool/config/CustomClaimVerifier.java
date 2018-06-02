package com.fangyuan.myschool.config;

import lombok.val;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.token.store.JwtClaimsSetVerifier;

import java.util.ArrayList;
import java.util.Map;

public class CustomClaimVerifier implements JwtClaimsSetVerifier {
    @Override
    public void verify(Map<String, Object> claims) throws InvalidTokenException {
        val username = claims.get("username");
        val roles = (ArrayList)claims.get("roles");
        if ((username == null) || (roles.size() == 0)) {
            throw new InvalidTokenException("user name claim is empty");
        }
    }
}
