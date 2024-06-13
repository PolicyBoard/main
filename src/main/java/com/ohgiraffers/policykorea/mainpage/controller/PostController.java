package com.ohgiraffers.policykorea.mainpage.controller;

import com.ohgiraffers.policykorea.mainpage.dto.PostDTO;
import com.ohgiraffers.policykorea.mainpage.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

//    @GetMapping("/mainpage")
//    public String getAllPosts(Model model) {
//        model.addAttribute("mainpage", postService.getAllPosts());
//        return "mainpage/mainpage";
//    }

    // 첫 페이지를 보여주는 메서드
    @GetMapping("/firstpage")
    public String getFirstPage(Model model) {
        return getPage(null,1, model);
    }

    // 특정 페이지를 보여주는 메서드
    @GetMapping("/mainpage/{pageNum}")
    public String getPage(@RequestParam(required = false) String gender, @PathVariable int pageNum, Model model) {
        int pageSize = 10; // 페이지당 게시물 수
        model.addAttribute("currentPage", pageNum);

        List<PostDTO> posts;
        if (gender != null && !gender.isEmpty()) {
            posts = postService.getPostsByGender(gender);
        } else {
            posts = postService.getAllPosts();
        }
        int maxIndex = Math.min(pageSize * pageNum, posts.size());
        int totalPages = (posts.size() + pageSize - 1)/pageSize; // 전체 페이지 수 계산
        posts = posts.subList(pageSize * (pageNum - 1), maxIndex);

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("mainpage", posts); // 해당 페이지의 게시물 목록 조회
        return "mainpage/mainpage";
    }

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시물 내용 보기
    @GetMapping("/content")
    public String showPostContent(@RequestParam("p") Long postId, Model model) {
        // postId에 해당하는 게시물 정보 가져오기
        PostDTO post = postService.getPostById(postId);

        // 가져온 게시물 정보를 모델에 추가하여 뷰에 전달
        model.addAttribute("post", post);

        // content.html 뷰로 이동
        return "board/post-content";
    }

//    @GetMapping("/mainpage/{pageNum}/gender")
//    public String getPosts(@RequestParam(required = false) String gender, Model model) {
//        List<PostDTO> posts;
//        if (gender != null && !gender.isEmpty()) {
//            posts = postService.getPostsByGender(gender);
//        } else {
//            posts = postService.getAllPosts();
//        }
//        model.addAttribute("mainpage", posts);
//        model.addAttribute("totalPages", 1);
//        return "mainpage/mainpage";
//    }

}
