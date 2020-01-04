package com.liefeng.studio.stduio.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Data
@Alias("say")
public class Say {

    private Integer say_id;

    private String user_name;

    private String say_title;

    private String say_content;

    private String say_date;

    private List<SaySayComment> comment;

    private String user_icon;


}
