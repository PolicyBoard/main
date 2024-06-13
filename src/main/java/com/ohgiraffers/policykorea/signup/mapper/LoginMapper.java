package com.ohgiraffers.policykorea.signup.mapper;

import com.ohgiraffers.policykorea.signup.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("SELECT * FROM member WHERE email like #{email} and password like #{password};")
    Member getLoginId(String email,String password);


}
