package com.ohgiraffers.policykorea.login.service;

import com.ohgiraffers.policykorea.login.Member;
import com.ohgiraffers.policykorea.login.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    private final MemberMapper memberMapper;

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

    public boolean signup(Member member) {
        // 이메일 중복 체크
        if (isEmailExists(member.getEmail())) {
            return false;
        }

        try {
            // 회원 정보 저장
            memberMapper.insert(member);
            return true; // 회원 가입 성공
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 회원 가입 실패
        }
    }
}
