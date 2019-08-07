package com.liefeng.studio.stduio.mapper;

import com.github.pagehelper.util.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class TaskProvider {

    public String getAllTask(@Param("search_key") String search_key){
        SQL selectSQL = new SQL();
        selectSQL.SELECT("task_id,task_name,task_owner,task_description,task_start_time,task_end_time")
                .FROM("task");
        if (!StringUtil.isEmpty(search_key)) {
            selectSQL.WHERE("task_owner LIKE CONCAT('%', #{search_key}, '%')");
        }
        selectSQL.ORDER_BY("task_start_time DESC");
        return selectSQL.toString();
    }
}
