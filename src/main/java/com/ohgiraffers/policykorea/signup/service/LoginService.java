package com.ohgiraffers.policykorea.signup.service;

import com.ohgiraffers.policykorea.signup.dto.Member;
import com.ohgiraffers.policykorea.signup.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
   private LoginMapper loginMapper;

    public Member getLoginId(String email,String password){

        return loginMapper.getLoginId(email,password);

    }
}
