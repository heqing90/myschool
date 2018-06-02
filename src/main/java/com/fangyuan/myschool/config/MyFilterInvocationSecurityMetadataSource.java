package com.fangyuan.myschool.config;

import com.fangyuan.myschool.service.PermissionServiceImpl;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

@Service
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionServiceImpl permissionService;

    private HashMap<String, Collection<ConfigAttribute>> map =null;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map == null) {
            map = new HashMap<>();
            val permissions = permissionService.findAll();
            for (val permission : permissions) {
                val array = new ArrayList<ConfigAttribute>();
                val roles = permissionService.findByPermissionId(permission.getId());
                for (val role : roles) {
                    val cfg = new SecurityConfig(role.getName());
                    array.add(cfg);
                }
                map.put(permission.getMenu(), array);
            }
        }
        val request = ((FilterInvocation) object).getHttpRequest();
        for (val it : map.entrySet()) {
            val matcher = new AntPathRequestMatcher(it.getKey());
            if (matcher.matches(request)) {
                return it.getValue();
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
