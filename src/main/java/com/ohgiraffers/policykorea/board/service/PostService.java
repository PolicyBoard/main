package com.ohgiraffers.policykorea.board.service;

import com.ohgiraffers.policykorea.board.Post;
import com.ohgiraffers.policykorea.board.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    public List<Post> getAllPosts() {
        return postMapper.findAll();
    }

    public Post getPostById(int id) {
        return postMapper.findById(id);
    }

    public void insertPost(Post post) {

            postMapper.insert(post);

    }

    public void updatePost(Post post) {

        postMapper.update(post);

    }

    public void deletePost(int id) {
        postMapper.delete(id);
    }
}