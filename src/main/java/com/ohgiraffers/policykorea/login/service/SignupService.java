package com.ohgiraffers.policykorea.login.service;

import com.ohgiraffers.policykorea.login.Member;
import com.ohgiraffers.policykorea.login.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignupService {

    private final MemberMapper memberMapper;
    private static final Logger logger = LoggerFactory.getLogger(SignupService.class);

    @Autowired
    public SignupService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public boolean isEmailExists(String email) {
        return memberMapper.countByEmail(email) > 0;
    }

    public boolean isIdExists(String id) {
        return memberMapper.countById(id) > 0;
    }

    @Transactional
    public boolean signup(Member member) {
        logger.info("SignupService - Signup requested: {}", member);
        // 회원 정보 저장
        try {
            memberMapper.insert(member);
            return true; // 회원 가입 성공
        } catch (Exception e) {
            logger.error("SignupService - Signup failed: {}", e.getMessage());
            return false; // 회원 가입 실패
        }
    }
}
