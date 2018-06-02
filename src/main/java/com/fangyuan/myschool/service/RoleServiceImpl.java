package com.fangyuan.myschool.service;

import com.fangyuan.myschool.mapper.RoleMapper;
import com.fangyuan.myschool.mapper.UserRoleMapper;
import com.fangyuan.myschool.model.Role;
import com.fangyuan.myschool.model.RoleExample;
import com.fangyuan.myschool.model.UserRoleExample;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> findByUserId(Long userId) {
        val ex = new UserRoleExample();
        val c = ex.createCriteria();
        c.andIsDeletedEqualTo(Boolean.FALSE);
        c.andUserIdEqualTo(userId);
        val userRoles = userRoleMapper.selectByExample(ex);
        if (userRoles.size() > 0) {
            val roleIds = new ArrayList<Long>();
            for (val it : userRoles) {
                roleIds.add(it.getRoleId());
            }
            val e = new RoleExample();
            e.createCriteria().andIsDeletedEqualTo(Boolean.FALSE).andIdIn(roleIds);
            return roleMapper.selectByExample(e);
        } else {
            return new ArrayList<Role>();
        }
    }

    public List<Role> findByIds(List<Long> roleIds) {
        val e = new RoleExample();
        e.createCriteria().andIsDeletedEqualTo(Boolean.FALSE)
                .andIdIn(roleIds);
        return roleMapper.selectByExample(e);
    }

}
