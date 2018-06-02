package com.fangyuan.myschool.service;

import com.fangyuan.myschool.comm.UserCreateReqData;
import com.fangyuan.myschool.comm.UserUpdateReqData;
import com.fangyuan.myschool.exception.MyException;
import com.fangyuan.myschool.mapper.UserMapper;
import com.fangyuan.myschool.model.User;
import com.fangyuan.myschool.model.UserExample;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.hibernate.validator.internal.util.privilegedactions.NewSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.util.Password;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl {

    @Autowired
    private UserMapper userMapper;

    public User findByPhone(String phone) {
        val ex = new UserExample();
        ex.createCriteria().andIsDeletedEqualTo(Boolean.FALSE).andPhoneEqualTo(phone);
        val users = userMapper.selectByExample(ex);
        if (users.size() != 1) {
            throw new MyException("Too many users found!");
        } else if(users.size() == 0) {
            throw new MyException("user does not exist!");
        }
        return users.get(0);
    }

    public User findByUserId(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> findAll() {
        val ex = new UserExample();
        ex.createCriteria().andIsDeletedEqualTo(Boolean.FALSE);
        return userMapper.selectByExample(ex);
    }

    @Transactional
    public Long create(UserCreateReqData userAddReqData) {
        val ex = new UserExample();
        val c = ex.createCriteria().andIsDeletedEqualTo(Boolean.FALSE).andPhoneEqualTo(userAddReqData.getPhone());
        if (userMapper.selectByExample(ex).size() > 0) {
            throw new MyException("user already exists.");
        }
        val newUser = new User();
        newUser.setUsername(userAddReqData.getUsername());
        newUser.setPassword(userAddReqData.getPassword());
        newUser.setTitle(userAddReqData.getTitle());
        newUser.setPhone(userAddReqData.getPhone());
        newUser.setAddress(userAddReqData.getAddress());
        newUser.setSalt("my_school");
        userMapper.insertSelective(newUser);
        return newUser.getId();
    }

    @Transactional
    public void update(UserUpdateReqData userUpdateReqData) {
        val newUser = new User();
        newUser.setId(userUpdateReqData.getUserId());
        if (userUpdateReqData.getUsername() != null) newUser.setUsername(userUpdateReqData.getUsername());
        if (userUpdateReqData.getPassword() != null) newUser.setPassword(userUpdateReqData.getPassword());
        if (userUpdateReqData.getTitle() != null) newUser.setTitle(userUpdateReqData.getTitle());
        if (userUpdateReqData.getPhone() != null) newUser.setPhone(userUpdateReqData.getPhone());
        if (userUpdateReqData.getAddress() != null) newUser.setAddress(userUpdateReqData.getAddress());
        userMapper.updateByPrimaryKeySelective(newUser);
    }

    @Transactional
    public int delete(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }
}
