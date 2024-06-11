package com.ohgiraffers.policykorea.mainpage.mapper;

import com.ohgiraffers.policykorea.mainpage.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("SELECT * FROM post")
    List<PostDTO> getAllPoints();
}
