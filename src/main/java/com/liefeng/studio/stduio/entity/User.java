package com.liefeng.studio.stduio.entity;


import lombok.Data;
import org.apache.ibatis.type.Alias;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @Author: 飞宇
 * @Date: 2019/4/25 15:51
 * @Version 1.0
 */


@Data
@Alias("user")
public class User {

    private String user_id;
    private String user_name;
    private String user_email;
    private String user_phone;
    private String user_address;

}
