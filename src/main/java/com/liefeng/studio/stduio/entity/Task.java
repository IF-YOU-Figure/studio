package com.liefeng.studio.stduio.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("task")
public class Task {


    private Integer taskId;

    private String taskName;

    private String taskDescription;

    private String taskOwner;

    private Timestamp taskStartTime;

    private Timestamp taskEndTime;
}
