package com.liefeng.studio.stduio.mapper;

import com.liefeng.studio.stduio.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @SelectProvider(type = UserProvider.class, method = "getAllUser")
    List<User> getAllUser(@Param("search_key") String search_key);

    @Select("SELECT user_id, user_name, user_phone,user_email, user_address FROM user WHERE user_id=#{user_id}")
    User getUserById(@Param("user_id") String user_id);

    @Select("SELECT user_name, user_password FROM user WHERE user_name=#{user_name} and user_password=#{user_password}")
    User checkUser(@Param("user_name") String user_name, @Param("user_password") String user_password);

    @Insert("INSERT INTO user(user_name,user_phone,user_password,user_password,user_email,user_address) values (#{user_name},#{user_phone},#{user_password},#{user_email},#{user_address})")
    void registerUser(@Param("user_name") String user_name,
                      @Param("user_phone") String user_phone,
                      @Param("user_password") String user_password,
                      @Param("user_email") String user_email,
                      @Param("user_address") String user_address);



}
