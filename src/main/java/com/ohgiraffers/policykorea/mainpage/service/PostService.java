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

    public List<PostDTO> getAllPoints() {
        return postMapper.getAllPoints();
    }
}
