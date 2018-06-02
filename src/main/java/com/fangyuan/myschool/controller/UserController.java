package com.fangyuan.myschool.controller;

import com.fangyuan.myschool.comm.MyResponse;
import com.fangyuan.myschool.comm.UserCreateReqData;
import com.fangyuan.myschool.comm.UserCreateResData;
import com.fangyuan.myschool.comm.UserUpdateReqData;
import com.fangyuan.myschool.exception.MyException;
import com.fangyuan.myschool.service.UserServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@RestController
@Slf4j
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public MyResponse getAllUsers(HttpServletRequest request,
                                  @RequestParam(required = false) Integer pageSize,
                                  @RequestParam(required = false) Integer pageNum) throws Exception {
        log.info("get user.");

        PageHelper.startPage(pageNum != null ? pageNum : 1, pageSize != null ? pageSize : 500);
        val users = userService.findAll();
        return new MyResponse(0, "", new PageInfo(users));
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public MyResponse getUserInfo(HttpServletRequest request,
                                  @PathVariable("id") Long userId) throws Exception {
        log.info("get user info.");
        val user = userService.findByUserId(userId);
        return new MyResponse(0, "", user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public MyResponse addUser(HttpServletRequest request,
                              @NotNull @RequestBody UserCreateReqData userCreateReqData) throws Exception {
        log.info("add user");
        val userId = userService.create(userCreateReqData);
        val resData = new UserCreateResData();
        resData.setUserId(userId);
        return new MyResponse(0, "", resData);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public MyResponse deleteUser(HttpServletRequest request,
                                 @PathVariable("id") Long userId) throws Exception {
        log.info("delete user, id = " + userId);
        if (userService.delete(userId) != 1) throw new MyException("Error: failed to delete user.", -2);
        return new MyResponse(0, "", null);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public MyResponse deleteUser(HttpServletRequest request,
                                 @NotNull @RequestBody UserUpdateReqData userUpdateReqData) throws Exception {

        userService.update(userUpdateReqData);
        return new MyResponse(0, "", null);
    }

    //TODO: search
    @RequestMapping(value = "/users/search", method = RequestMethod.GET)
    public MyResponse searchUser(HttpServletRequest request) throws Exception {
        return new MyResponse(0, "", null);
    }
}
