package com.liefeng.studio.stduio.mapper;

import com.github.pagehelper.util.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class UserProvider {

    public String getAllUser(@Param("search_key") String search_key){
        SQL selectSQL = new SQL();
        selectSQL.SELECT("user_id,user_name,user_email,user_phone,user_address")
                .FROM("user");
        if (!StringUtil.isEmpty(search_key)) {
            selectSQL.WHERE("user_address LIKE CONCAT('%', #{search_key}, '%')");
        }
        selectSQL.ORDER_BY("user_id DESC");
        return selectSQL.toString();
    }

}
