package com.liefeng.studio.stduio.mapper;

import com.liefeng.studio.stduio.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskMapper {

    @SelectProvider(type = TaskProvider.class, method = "getAllTask")
    List<Task> getAllTask(@Param("search_key") String search_key);

    @Select("SELECT A.task_name,A.task_owner,A.task_description,A.task_start_time,A.task_end_time FROM task A ,task_user_mapping B where A.task_name=B.task_name and  B.user_name=#{user_name}" )
    List<Task> getMyTaskMapper(@Param("user_name") String user_name);
}
