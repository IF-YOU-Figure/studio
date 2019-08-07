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

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }

    private String userId;

    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 3)
    private String userName;

    @NotEmpty(message = "密码不能为空")
    @Size(max = 100)
    private String userPassword;

    @NotEmpty(message = "邮箱不能为空")
    @Size(max = 50)
    @Email(message = "邮箱格式不对")
    private String userEmail;

    @NotEmpty(message = "手机号不能为空")
    @Size(max = 12)
    private String userPhone;

    @Size(max = 124)
    private String userAddress;


    public User() {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
    }
}
