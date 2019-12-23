package com.liefeng.studio.stduio.mapper;

import com.liefeng.studio.stduio.entity.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BlogMapper {

    @Select("SELECT blog_id,blog_name,blog_message,blog_icon,user_id,create_date,blog_zan,blog_category FROM blog WHERE blog_name=#{blog_name}")
    Blog getBlogByName(@Param("blog_name") String blog_name);



}
