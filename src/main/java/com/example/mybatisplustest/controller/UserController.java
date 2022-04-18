package com.example.mybatisplustest.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplustest.mapper.UserMapper;
import com.example.mybatisplustest.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *RestController = @Controller+@ResponseBody
 * @author ${author}
 * @since 2022-04-18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/tes")
    public Page<User> test(){
        Page<User> userPage = new Page<>(1,4);
        return userMapper.selectPage(userPage, null);
    }



}

