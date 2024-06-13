package com.ohgiraffers.policykorea.login.service;

import com.ohgiraffers.policykorea.login.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final MemberMapper memberMapper;

    @Autowired
    public LoginService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public boolean isEmailExists(String email) {
        return memberMapper.countByEmail(email) > 0;
    }

    public boolean selectId(String id) {
        return memberMapper.countById(id) > 0;
    }
}




