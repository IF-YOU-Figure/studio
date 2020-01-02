package com.liefeng.studio.stduio.mapper;

import com.liefeng.studio.stduio.entity.Say;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SayMapper {

    @Select("SELECT * FROM say")
    List<Say> getSendSay();

    @Insert("INSERT INTO say(user_name,say_title,say_content) VALUES (#{user_name},#{say_title},#{say_content})")
    void writeSay(@Param("user_name") String user_name,@Param("say_title") String say_title,@Param("say_content") String say_content);

    @Select("SELECT COUNT(*) FROM say")
    int getSayNumberSay();


}
