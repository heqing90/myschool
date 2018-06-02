package com.fangyuan.myschool.service;

import com.fangyuan.myschool.mapper.UserMapper;
import com.fangyuan.myschool.mapper.UserRoleMapper;
import com.fangyuan.myschool.model.User;
import com.fangyuan.myschool.model.UserExample;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserAuthServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public User findByPhone(String phone) {
        try {
            val ex = new UserExample();
            ex.createCriteria().andIsDeletedEqualTo(false).andPhoneEqualTo(phone);
            val users = userMapper.selectByExample()
        } catch (Exception e) {
            return null;
        }
    }
}
