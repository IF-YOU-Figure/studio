package com.liefeng.studio.stduio.mapper;


import com.liefeng.studio.stduio.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    @SelectProvider(type = BookProvider.class, method = "getAllBook")
    List<Book> getAllBook(@Param("search_key") String search_key);
}
