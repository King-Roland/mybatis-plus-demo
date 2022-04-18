package com.example.mybatisplustest.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.example.mybatisplustest.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author DELL
* @description 针对表【table_user】的数据库操作Mapper
* @createDate 2022-04-18 14:26:21
* @Entity com.example.mybatisplustest.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    List<User> selectAllByUserName(@Param("userName") String userName);
}




