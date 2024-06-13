package com.ohgiraffers.policykorea.board.controller;

import com.ohgiraffers.policykorea.board.Comment;
import com.ohgiraffers.policykorea.board.Post;
import com.ohgiraffers.policykorea.board.service.CommentService;
import com.ohgiraffers.policykorea.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/board")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @GetMapping
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts";
    }


    @PostMapping("/insert")
    public String savePost(@ModelAttribute("post") Post post) {
        postService.insertPost(post);

        return "redirect:/board/post?id="+post.getPost_id();
    }

   /* @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable int id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "edit_post";
    }*/

    @PostMapping("/edit")
    public String editPostForm(@RequestParam("id") int id, Model model) {
        System.out.println(id);
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "board/setboard";
    }

 /*   @PostMapping("edit/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute("post") Post post) {
        post.setPostId(Math.toIntExact(id));
        postService.insertPost(post);
        return "redirect:/posts";
    }*/

  /*  @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable int id) {
        postService.deletePost(id);
        return "redirect:/";
    }*/

    @GetMapping("/delete")
    public String deletePost(@RequestParam("id") int id) {
        Post post = postService.getPostById(id);
        System.out.println(post.getPost_id());
        postService.deletePost(id);
        return "redirect:/post/mainpage/1";
    }

    @GetMapping("/board")
    public String mainBoard() {
        return "board/board1";
    }

    @GetMapping("/post")
    public String getPostById(@RequestParam("id") int id, Model model) {

        Post post = postService.getPostById(id);
        List<Comment> comments = commentService.getCommentsByPostId(id);
        model.addAttribute("post", post);
        model.addAttribute("comment", comments);
        return "board/board";
    }


    @GetMapping("/setboard")
    public String setBoard(){
        return "board/setboard";
    }

    @GetMapping("/createboard")
    public String createBoard(){
        return "board/createboard";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute("post") Post post) {
        System.out.println(post.getPost_id());
        postService.updatePost(post);

        return "redirect:/board/post?id="+post.getPost_id();
    }

    @PostMapping("/incomment")
    public String insertComment(@ModelAttribute("comment") Comment comment){
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 년-월-일-시-분 형식으로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년-MM월-dd일-HH시-mm분");
        String formattedDateTime = currentDateTime.format(formatter);

        comment.setCreate_time(formattedDateTime);


        commentService.insertPost(comment);
        return "redirect:/board/post?id="+comment.getPost_id();

    }

    @PostMapping("/like")
    public String likeComment(@RequestParam("comment_id") int commentId, @RequestParam("post_id") int postId) {
        commentService.incrementLikes(commentId,postId);
        return "redirect:/board/post?id=" + postId;
    }

    @PostMapping("/report")
    public String reportPost(@RequestParam("post_id") int postId) {
        postService.reportPost(postId);
        return "redirect:/board/post?id=" + postId;
    }



}