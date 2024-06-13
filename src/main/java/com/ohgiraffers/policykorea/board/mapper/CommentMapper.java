package com.ohgiraffers.policykorea.board.mapper;

import com.ohgiraffers.policykorea.board.Comment;
import com.ohgiraffers.policykorea.board.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("SELECT * FROM Comment WHERE post_id = #{id}")
    List<Comment> findByCommentId(int id);


    @Insert("INSERT INTO Comment(author, comment_content, likes, post_id, create_time) " +
            "VALUES(#{author}, #{comment_content}, #{likes}, #{post_id}, #{create_time})")
    @Options(useGeneratedKeys = true, keyProperty = "comment_id")
    void insert(Comment comment);


    @Update("UPDATE Comment SET likes = likes + 1 WHERE comment_id = #{comment_id}")
    void like(int comment_id);

}
