package com.ohgiraffers.policykorea.mainpage.mapper;

import com.ohgiraffers.policykorea.mainpage.dto.PostDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("SELECT * FROM Post")
    List<PostDTO> getAllPosts();

    // 페이징 처리를 위한 메서드
    @Select("SELECT * FROM Post LIMIT #{offset}, #{pageSize}")
    List<PostDTO> getPostsPerPage(@Param("offset") int offset, @Param("pageSize") int pageSize);

    // 전체 게시물 수를 조회하는 메서드
    @Select("SELECT COUNT(*) FROM Post")
    int getTotalPosts();

    @Select("SELECT * FROM Post WHERE post_id = #{postId}")
    PostDTO getPostById(Long postId);
}
