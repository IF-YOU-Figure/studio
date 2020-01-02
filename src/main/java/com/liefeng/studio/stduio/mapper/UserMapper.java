package com.liefeng.studio.stduio.mapper;

import com.liefeng.studio.stduio.VO.UserVO;
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

    @Select("SELECT * FROM user WHERE user_email=#{user_email}")
    User checkUser(@Param("user_email") String user_email);

    @Insert("INSERT INTO user(user_name,user_phone,user_password,user_email,user_address) values (#{user_name},#{user_phone},#{user_password},#{user_email},#{user_address})")
    void registerUser(@Param("user_name") String user_name,
                      @Param("user_phone") String user_phone,
                      @Param("user_password") String user_password,
                      @Param("user_email") String user_email,
                      @Param("user_address") String user_address);

    @Update("UPDATE user SET user_name=#{new_user_name},user_email=#{new_user_email},user_password=#{new_user_password} where user_name=#{user_name}")
    void modifyUser(@Param("new_user_name") String new_user_name,
                    @Param("user_name") String user_name,
                    @Param("new_user_email") String new_user_email,
                    @Param("new_user_password") String new_user_password);

    @Update("UPDATE user SET user_icon=#{user_icon} where user_name=#{user_name}")
    void updateIcon(@Param("user_name") String user_name,
                    @Param("user_icon") String user_icon);

    @Select("SELECT user_icon FROM user WHERE user_name=#{user_name}")
    Object getIcon(@Param("user_name") String user_name);

    @Select("SELECT COUNT(*) FROM user")
    int getOnlineNumber();

    @Select("SELECT * FROM user WHERE user_name=#{user_name}")
    User getUser(@Param("user_name") String user_name);

    @Select("SELECT * FROM user")
    List<UserVO> getUserAll();

    @Update("UPDATE user SET user_email=#{user_email},user_phone=#{user_phone},user_address=#{user_address},user_position=#{user_position},user_qq=#{user_qq},user_age=#{user_age},user_grade=#{user_grade},user_direction=#{user_direction} where user_name=#{user_name}")
    void modifyDetail(@Param("user_name") String user_name,
                      @Param("user_email") String user_email,
                      @Param("user_phone") String user_phone,
                      @Param("user_address") String user_address,
                      @Param("user_position") String user_position,
                      @Param("user_qq") String user_qq,
                      @Param("user_age") String user_age,
                      @Param("user_grade") String user_grade,
                      @Param("user_direction") String user_direction);


}
