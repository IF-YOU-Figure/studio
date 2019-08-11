package com.liefeng.studio.stduio.entity;


import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("book")
public class Book {

    private Integer book_id;

    private String book_name;

    private String book_category;

    private String book_number;

    private String book_stock;

    private String book_publish;

    private String state;
}
