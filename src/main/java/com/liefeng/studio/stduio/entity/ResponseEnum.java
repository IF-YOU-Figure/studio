package com.liefeng.studio.stduio.entity;

public enum ResponseEnum {
    SUCCESS("1000", "成功"),
    CHECK_SIGN_FAILED("1001", "签名验证失败"),
    USER_NOT_LOGIN("1002", "用户未登陆"),
    SYSTEM_ERROR("1009", "系统异常"),
    ;

    private String code;

    private String msg;

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
