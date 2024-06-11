package com.ohgiraffers.policykorea.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/signup")
    public String signup() {
        return "login/signup";
    }


    @GetMapping("/login")
    public String login() {
        return "login/login";
    }
}


