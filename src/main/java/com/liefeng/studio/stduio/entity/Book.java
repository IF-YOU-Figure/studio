package com.liefeng.studio.stduio.entity;


import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("book")
public class Book {

    private Integer bookId;

    private String bookName;

    private String bookCategory;

    private Integer bookNumber;

    private Integer bookStock;

    private String bookPublish;

    private String state;
}
