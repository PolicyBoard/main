package com.ohgiraffers.policykorea.login.controller;

import com.ohgiraffers.policykorea.login.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("")
    public String loginPage() {
        return "login/login"; // login.html 페이지로 이동
    }


    @PostMapping("/verify-email")
    @ResponseBody
    public ResponseEntity<Boolean> verifyEmail(@RequestParam String email) {
        logger.info("Verifying email: {}", email);
        boolean exists = loginService.isEmailExists(email);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/confirm-id")
    @ResponseBody
    public ResponseEntity<Boolean> confirmId(@RequestParam String id) {
        logger.info("Confirming ID: {}", id);
        boolean exists = loginService.selectId(id);
        return ResponseEntity.ok(!exists); // ID가 존재하면 false를 반환
    }
}
