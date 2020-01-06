package com.liefeng.studio.stduio.mapper;


import com.liefeng.studio.stduio.VO.WeeklyVO;
import com.liefeng.studio.stduio.entity.Target_content;
import com.liefeng.studio.stduio.entity.Weekly;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface WeeklyMapper {


    @Insert("INSERT INTO weekly(user_name,evaluate,plan,week,date) VALUES (#{user_name},#{evaluate},#{plan},#{week},NOW())")
    void createWeekly(@Param("user_name") String user_name,
                      @Param("evaluate") String evaluate,
                      @Param("plan") String plan,
                      @Param("week") String week
                      );


    @Select("SELECT * FROM weekly WHERE date=#{date}")
    Weekly getDetail(@Param("date") String date);

    @Insert("INSERT INTO target_content(user_name,target_content,situation,week,date_task) VALUES (#{user_name},#{target_content},#{situation},#{week},#{date_task})")
    void createWeeklyDetail(@Param("user_name") String user_name,
                      @Param("target_content") String target_content,
                      @Param("situation") String situation,
                      @Param("week") String week,
                      @Param("date_task") String date_task
                        );

    @Select("SELECT user.user_icon,user.user_name,user.user_direction,weekly.date,weekly.week FROM user,weekly WHERE user.user_name=weekly.user_name ")
    List<WeeklyVO> getWeekly();


    @Select("SELECT target_content,situation,date_task FROM target_content WHERE user_name=#{user_name} and week=#{week}")
    List<Target_content> getTargetContentPersonal(@Param("user_name") String user_name,@Param("week") String week);

    @Select("SELECT plan,evaluate,date FROM weekly WHERE user_name=#{user_name} and week=#{week}")
    Weekly getWeeklyPersonal(@Param("user_name") String user_name,@Param("week") String week);

}
