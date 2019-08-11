package com.liefeng.studio.stduio.mapper;


import com.liefeng.studio.stduio.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    @SelectProvider(type = BookProvider.class, method = "getAllBook")
    List<Book> getAllBook(@Param("search_key") String search_key);

    @Select("SELECT book_id,book_name,book_category,book_number,book_publish,state,book_stock FROM book where book_name LIKE CONCAT('%',#{book_name},'%') ")
    List<Book> findBookByName(@Param("book_name") String book_name);

    @Select("SELECT book_stock FROM book where book_name=#{book_name}")
    String getBookNumber(@Param("book_name") String book_name);

    @Insert("INSERT INTO book_borrow(book_name,user_name,borrow_date,return_date) VALUES (#{book_name},#{user_name},NOW(),DATE_ADD(now(),INTERVAL 1 MONTH)})")
    void borrowBook(@Param("book_name") String book_name,@Param("user_name") String user_name);

    @Update("UPDATE book set state=#{不可借},book_stock=#{0} where book_name=#{book_name} ")
    void updateBookOnlyOne(@Param("book_name") String book_name);

    @Update("UPDATE book set book_stock=book_stock-1 where book_name=#{book_name} ")
    void updateBookNotOnlyOne(@Param("book_name") String book_name);

}
