package com.liefeng.studio.stduio.mapper;

import com.github.pagehelper.util.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class BookProvider {

    public String getAllTask(@Param("search_key") String search_key){
        SQL selectSQL = new SQL();
        selectSQL.SELECT("book_id,book_name,book_category,book_number,book_publish,state,book_stock")
                .FROM("book");
        if (!StringUtil.isEmpty(search_key)) {
            selectSQL.WHERE("book_category LIKE CONCAT('%', #{search_key}, '%')");
        }
        selectSQL.ORDER_BY("book_id DESC");
        return selectSQL.toString();
    }
}
