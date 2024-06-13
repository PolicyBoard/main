package com.ohgiraffers.policykorea.mainpage.mapper;

import com.ohgiraffers.policykorea.mainpage.dto.PostDTO1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PostMapper1 {

    @Select("SELECT * FROM Post")
    List<PostDTO1> getAllPosts();

    // 페이징 처리를 위한 메서드
    @Select("SELECT * FROM Post LIMIT #{offset}, #{pageSize}")
    List<PostDTO1> getPostsPerPage(@Param("offset") int offset, @Param("pageSize") int pageSize);

    // 전체 게시물 수를 조회하는 메서드
    @Select("SELECT COUNT(*) FROM Post")
    int getTotalPosts();

    @Select("SELECT * FROM Post WHERE post_id = #{postId}")
    PostDTO1 getPostById(Long postId);

    // 성별로 게시물 가져오기
    @Select("SELECT * FROM Post WHERE gender = #{gender}")
    List<PostDTO1> getPostsByGender(@Param("gender") String gender);
}
