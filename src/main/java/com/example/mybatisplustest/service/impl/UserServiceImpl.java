package com.example.mybatisplustest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplustest.pojo.User;
import com.example.mybatisplustest.service.UserService;
import com.example.mybatisplustest.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author DELL
* @description 针对表【table_user】的数据库操作Service实现
* @createDate 2022-04-18 14:26:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




