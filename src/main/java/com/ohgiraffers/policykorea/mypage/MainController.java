package com.ohgiraffers.policykorea.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String defaultMain() {
        return "main";
    }

    @GetMapping("main")
    public void main() {}
}
