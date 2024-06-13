package com.ohgiraffers.policykorea.login.controller;

import com.ohgiraffers.policykorea.login.Member;
import com.ohgiraffers.policykorea.login.service.SignupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final SignupService signupService;
    private static final Logger logger = LoggerFactory.getLogger(SignupController.class);

    @Autowired
    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @GetMapping("")
    public String signupPage(Model model) {
        model.addAttribute("member", new Member()); // 빈 Member 객체를 모델에 추가
        return "login/signup";
    }

    @PostMapping("/verify-email")
    @ResponseBody
    public ResponseEntity<Boolean> verifyEmail(@RequestParam String email) {
        logger.info("Verifying email: {}", email);
        boolean exists = signupService.isEmailExists(email);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/confirm-id")
    @ResponseBody
    public ResponseEntity<Boolean> confirmId(@RequestParam String id) {
        logger.info("Confirming ID: {}", id);
        boolean exists = signupService.isIdExists(id);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/register")
    public String processSignup(@ModelAttribute Member member, Model model) {
        logger.info("SignupController - Registering member: {}", member);
        boolean signupSuccess = signupService.signup(member);
        if (signupSuccess) {
            // 회원가입 성공 시 메인 페이지로 리다이렉트
            return "redirect:/";
        } else {
            // 회원가입 실패 시 실패 메시지를 모델에 추가하여 회원가입 페이지로 이동
            model.addAttribute("signupError", "회원가입에 실패했습니다. 다시 시도해주세요.");
            return "login/signup";
        }
    }
}
