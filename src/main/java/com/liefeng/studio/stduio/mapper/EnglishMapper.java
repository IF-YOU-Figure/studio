package com.liefeng.studio.stduio.mapper;


import com.liefeng.studio.stduio.VO.EnglishVo;
import com.liefeng.studio.stduio.entity.English;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnglishMapper {

    @Select("SELECT monday,tuesday,wednesday,thursday,friday,saturday,sunday FROM english WHERE user_name=#{user_name} ORDER BY week desc LIMIT 0,1")
    English getCurrent(@Param("user_name") String user_name);

    @Select("SELECT monday,tuesday,wednesday,thursday,friday,saturday,sunday FROM english WHERE user_name=#{user_name} ORDER BY week desc LIMIT 1,1")
    English getBefore(@Param("user_name") String user_name);

    @Select("SELECT (monday+tuesday+wednesday+thursday+friday+saturday+sunday) AS number,user.user_icon,user.user_name FROM english,user WHERE week=#{week} AND english.user_name = user.user_name ORDER BY number DESC")
    List<EnglishVo> weekRanking(@Param("week") String week);

    @Select("SELECT SUM(number) AS number,t.user_icon,t.user_name FROM (SELECT (monday+tuesday+wednesday+thursday+friday+saturday+sunday) AS number,user.user_icon user_icon,user.user_name user_name\n" +
            "FROM english,user WHERE english.user_name = user.user_name ORDER BY number DESC) AS t GROUP BY t.user_name, t.user_icon ORDER BY number DESC")
    List<EnglishVo> totalRanking();

    @Select("SELECT week FROM english WHERE user_name=#{user_name} ORDER BY week DESC limit 0,1")
    String getWeek(@Param("user_name") String user_name);


    @UpdateProvider(type = EnglishProvider.class, method = "setWeek")
    void setWeek(@Param("user_name") String user_name,@Param("weekDay") String weekDay,@Param("clock") String clock,@Param("week") String week);


    @InsertProvider(type = EnglishProvider.class, method = "createWeek")
    void createWeek(@Param("user_name") String user_name,@Param("weekDay") String weekDay,@Param("clock") String clock,@Param("week") String week);





}
