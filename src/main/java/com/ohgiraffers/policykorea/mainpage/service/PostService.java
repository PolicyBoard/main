package com.ohgiraffers.policykorea.mainpage.service;

import com.ohgiraffers.policykorea.mainpage.dto.PostDTO;
import com.ohgiraffers.policykorea.mainpage.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    // 전체 게시물을 불러오는 메서드
    public List<PostDTO> getAllPosts() {
        return postMapper.getAllPosts();
    }

    // 페이징 처리를 위한 메서드
    public List<PostDTO> getPostsPerPage(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize; // 시작 위치 계산
        return postMapper.getPostsPerPage(offset, pageSize); // 특정 범위의 게시물 목록을 조회
    }

    // 전체 게시물 수를 반환하는 메서드
    public int getTotalPosts() {
        return postMapper.getTotalPosts();
    }

    // 전체 페이지 수를 계산하는 메서드
    public int getTotalPages(int pageSize) {
        int totalPosts = getTotalPosts();
        return (int) Math.ceil((double) totalPosts / pageSize);
    }

    public PostDTO getPostById(Long postId) {
        return postMapper.getPostById(postId);
    }
}
