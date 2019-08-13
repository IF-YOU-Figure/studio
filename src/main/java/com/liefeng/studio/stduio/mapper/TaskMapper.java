package com.liefeng.studio.stduio.mapper;

import com.liefeng.studio.stduio.entity.Task;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskMapper {

    @SelectProvider(type = TaskProvider.class, method = "getAllTask")
    List<Task> getAllTask(@Param("search_key") String search_key);

    @Select("SELECT A.task_name,A.task_owner,A.task_description,A.task_start_time,A.task_end_time FROM task A ,task_user_mapping B where A.task_name=B.task_name and  B.user_name=#{user_name}" )
    List<Task> getMyTaskMapper(@Param("user_name") String user_name);

    @Insert("INSERT INTO task(task_name,task_owner,task_description,task_start_time,task_end_time) values (#{task_name},#{task_owner},#{task_description} ,NOW(),DATE_ADD(now(),INTERVAL #{task_time}  MONTH))")
    void createTask(@Param("task_name") String task_name, @Param("task_owner") String task_owner, @Param("task_description") String task_description, @Param("task_time") String task_time);

}
