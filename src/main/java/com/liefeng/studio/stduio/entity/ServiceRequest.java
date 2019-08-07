package com.liefeng.studio.stduio.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceRequest implements Serializable {

    private JSONObject param;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this, SerializerFeature.WriteNonStringValueAsString);
    }

}
