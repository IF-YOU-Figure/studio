package com.liefeng.studio.stduio.mapper;

import com.liefeng.studio.stduio.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskMapper {

    @SelectProvider(type = TaskProvider.class, method = "getAllTask")
    List<Task> getAllTask(@Param("search_key") String search_key);
}
