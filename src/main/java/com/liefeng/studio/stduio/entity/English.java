package com.liefeng.studio.stduio.entity;


import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("english")
public class English {

    private Integer eng_id;
    private String week;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;
    private String user_name;


}
