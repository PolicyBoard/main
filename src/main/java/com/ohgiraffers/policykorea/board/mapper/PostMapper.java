package com.ohgiraffers.policykorea.board.mapper;

import com.ohgiraffers.policykorea.board.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {

    @Select("SELECT * FROM Post")
    List<Post> findAll();

    @Select("SELECT * FROM Post WHERE post_id = #{id}")
    Post findById(int id);

    @Insert("INSERT INTO Post(title, content, author, location, gender, start_time, end_time, status, likes, reports) " +
            "VALUES(#{title}, #{content}, #{author}, #{location}, #{gender}, #{startTime}, #{endTime}, #{status}, #{likes}, #{reports})")
    @Options(useGeneratedKeys = true, keyProperty = "postId")
    void insert(Post post);

    @Update("UPDATE Post SET title=#{title}, content=#{content}, author=#{author}, location=#{location}, gender=#{gender}, " +
            "start_time=#{startTime}, end_time=#{endTime}, status=#{status}, likes=#{likes}, reports=#{reports} WHERE post_id=#{postId}")
    void update(Post post);

    @Delete("DELETE FROM Post WHERE post_id = #{id}")
    void delete(int id);
}