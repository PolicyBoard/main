package com.ohgiraffers.policykorea.board.service;

import com.ohgiraffers.policykorea.board.Comment;
import com.ohgiraffers.policykorea.board.Post;
import com.ohgiraffers.policykorea.board.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentMapper  commentMapper;

    public List<Comment> getCommentsByPostId(int id) {
        return commentMapper.findByCommentId(id);
    }


    public void insertPost(Comment comment) {

        commentMapper.insert(comment);

    }

    public void incrementLikes(int commentId,int postId){

        commentMapper.like(commentId);

    }
}
