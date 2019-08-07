package com.liefeng.studio.stduio.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

public class ServiceResponse<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    public ServiceResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ServiceResponse(ResponseEnum code, T data) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.data = data;
    }

    public ServiceResponse(ResponseEnum code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public ServiceResponse(T data) {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.msg = ResponseEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public ServiceResponse() {
        this.code = ResponseEnum.SUCCESS.getCode();
        this.msg = ResponseEnum.SUCCESS.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this, SerializerFeature.WriteNonStringValueAsString);
    }
}

