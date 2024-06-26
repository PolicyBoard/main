package com.ohgiraffers.policykorea.signup.mapper;

import com.ohgiraffers.policykorea.signup.dto.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    @Select("SELECT * FROM members")
    List<Member> findAll();

    @Select("SELECT * FROM members WHERE member_id = #{id}")
    Optional<Member> findById(Long id);

    @Insert("INSERT INTO member(nickname, email, password, confirmPassword) VALUES (#{nickname}, #{email}, #{password}, #{confirmPassword})")
    @Options(useGeneratedKeys = true, keyProperty = "email")
    void insert(Member member);

    @Update("UPDATE member s SET nickname=#{nickname}, email=#{email}, password=#{password}, points=#{points} WHERE member_id = #{memberId}")
    void update(Member member);

    @Delete("DELETE FROM members WHERE member_id = #{id}")
    void delete(Long id);

    @Select("SELECT COUNT(*) FROM members WHERE email = #{email}")
    int countByEmail(String email);


    @Select("SELECT COUNT(*) FROM members WHERE id = #{id}")
    int countById(String id);
}



