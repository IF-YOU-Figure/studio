package com.liefeng.studio.stduio.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;


@Data
@Alias("task")
public class Task {


    private Integer task_id;

    private String task_name;

    private String task_description;

    private String task_owner;

    private String task_start_time;

    private String task_end_time;
}
