package com.ohgiraffers.policykorea.signup.controller;

import com.ohgiraffers.policykorea.signup.dto.Member;
import com.ohgiraffers.policykorea.signup.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(){return "/login/login";}

    @PostMapping("/insertlogin")
    public String insertlogin(@ModelAttribute("member") Member member){
        Member member1 = loginService.getLoginId(member.getEmail(), member.getPassword());

        System.out.println(member1);
        return "redirect:/post/mainpage/1";


    }

   /* @PostMapping("/insert")
    public String savePost() {
        postService.insertPost(post);

        return "redirect:/board/post?id="+post.getPost_id();
    }*/
}
