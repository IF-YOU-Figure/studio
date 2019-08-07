package com.liefeng.studio.stduio.mapper;

import com.liefeng.studio.stduio.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("SELECT * FROM user where user_name=#{user_name}")
    List<User> getAllUser(@Param("user_name") String User_name,@Param("search_key") String search_key);
}
