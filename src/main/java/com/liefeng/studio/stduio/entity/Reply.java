package com.liefeng.studio.stduio.entity;


import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("reply")
public class Reply {

    private Integer reply_id;

    private Integer comment_id;

    private String from_user_id;

    private String reply_date;

    private String reply_message;


}
