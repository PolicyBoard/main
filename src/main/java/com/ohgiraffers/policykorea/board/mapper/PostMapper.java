package com.ohgiraffers.policykorea.board.mapper;

import com.ohgiraffers.policykorea.board.Post;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface PostMapper {
    LocalDateTime createTime = LocalDateTime.now();
    LocalDateTime setTime = LocalDateTime.now();


    @Select("SELECT * FROM Post")
    List<Post> findAll();

    @Select("SELECT * FROM Post WHERE post_id = #{id}")
    Post findById(int id);

    @Insert("INSERT INTO Post(title, content, author, location, gender, start_time, end_time, status, likes, reports, url) " +
            "VALUES(#{title}, #{content}, #{author}, #{location}, #{gender}, #{start_time}, #{end_time}, #{status}, #{likes}, #{reports}, #{url})")
    @Options(useGeneratedKeys = true, keyProperty = "post_id")
    void insert(Post post);

    @Update("UPDATE Post SET title=#{title}, content=#{content}, author=#{author}, location=#{location}, gender=#{gender}, " +
            "start_time=#{start_time}, end_time=#{end_time}, status=#{status}, likes=#{likes}, reports=#{reports}, url=#{url} WHERE post_id=#{post_id}")
    void update(Post post);

    @Delete("DELETE FROM Post WHERE post_id = #{id}")
    void delete(int id);

    @Update("UPDATE Post SET reports = reports + 1 WHERE post_id = #{post_id}")
    void report(int post_id);
}