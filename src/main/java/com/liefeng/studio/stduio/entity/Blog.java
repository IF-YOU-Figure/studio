package com.liefeng.studio.stduio.entity;


import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("blog")
public class Blog {

    private Integer blog_id;

    private String blog_name;

    private String blog_message;

    private String blog_icon;

    private String user_id;

    private String create_date;

    private Integer blog_zan;

    private String blog_category;




}
