package com.liefeng.studio.stduio.mapper;

import com.liefeng.studio.stduio.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @SelectProvider(type = UserProvider.class, method = "getAllUser")
    List<User> getAllUser(@Param("search_key") String search_key);
}
