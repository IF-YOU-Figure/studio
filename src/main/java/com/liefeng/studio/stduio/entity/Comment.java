package com.liefeng.studio.stduio.entity;


import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("remark")
public class Comment {


    private Integer comment_id;

    private String comment_message;

    private Integer user_id;

    private String comment_date;

    private Integer blog_id;

    private Integer comment_zan;
}
