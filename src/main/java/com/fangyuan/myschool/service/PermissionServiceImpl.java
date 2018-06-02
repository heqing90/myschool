package com.fangyuan.myschool.service;

import com.fangyuan.myschool.mapper.PermissionMapper;
import com.fangyuan.myschool.mapper.RoleMapper;
import com.fangyuan.myschool.mapper.RolePermissionMapper;
import com.fangyuan.myschool.mapper.UserRoleMapper;
import com.fangyuan.myschool.model.*;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PermissionServiceImpl {
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    private RoleServiceImpl roleService;

    public List<Permission> findByUserId(Long userId) {
        val roles = roleService.findByUserId(userId);
        if (roles.size() > 0) {
            val roleIds =  new ArrayList<Long>();
            for (val it : roles) {
                roleIds.add(it.getId());
            }
            return findByRoleIds(roleIds);
        }
        return new ArrayList<Permission>();
    }

    public List<Permission> findAll() {
        val ex = new PermissionExample();
        ex.createCriteria().andIsDeletedEqualTo(Boolean.FALSE);
        return permissionMapper.selectByExample(ex);
    }

    public List<Permission> findByRoleIds(List<Long> roleIds) {
        val ex = new RolePermissionExample();
        val c = ex.createCriteria().andIsDeletedEqualTo(Boolean.FALSE);
        c.andRoleIdIn(roleIds);
        val rolePermissions  = rolePermissionMapper.selectByExample(ex);
        val permissionIds = new ArrayList<Long>();
        for (val it : rolePermissions) {
            permissionIds.add(it.getPermissionId());
        }
        if (permissionIds.size() > 0) {
            val e = new PermissionExample();
            e.createCriteria().andIsDeletedEqualTo(Boolean.FALSE).andIdIn(permissionIds);
            return permissionMapper.selectByExample(e);
        }
        return new ArrayList<Permission>();
    }

    public List<Role> findByPermissionId(Long permissionId) {
        val ex = new RolePermissionExample();
        ex.createCriteria().andIsDeletedEqualTo(Boolean.FALSE)
                .andPermissionIdEqualTo(permissionId);
        val rolePermissions  = rolePermissionMapper.selectByExample(ex);
        val roleIds = new ArrayList<Long>();
        for (val it : rolePermissions) {
            roleIds.add(it.getRoleId());
        }
        if (roleIds.size() > 0) {
            return roleService.findByIds(roleIds);
        }
        return new ArrayList<Role>();
    }
}
