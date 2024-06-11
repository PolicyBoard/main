package com.ohgiraffers.policykorea.mainpage.controller;

import com.ohgiraffers.policykorea.mainpage.dto.PostDTO;
import com.ohgiraffers.policykorea.mainpage.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String getPosts(Model model) {
        List<PostDTO> posts = postService.getAllPoints();
        model.addAttribute("posts", posts);
        return "posts";
    }
}
