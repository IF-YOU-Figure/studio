package com.liefeng.studio.stduio.entity;

import lombok.Data;

@Data
public class BookBorrow {

    Integer book_id;

    String book_name;

    String user_name;

    String borrow_date;

    String return_date;
}
