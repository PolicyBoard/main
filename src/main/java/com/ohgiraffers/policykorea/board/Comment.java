package com.ohgiraffers.policykorea.board;

public class Comment {

    private int comment_id;

    private String author;

    private String comment_content;

    private String create_time;

    private int likes;

    private String post_id;

    public Comment(int comment_id, String author, String comment_content, String create_time, int likes, String post_id) {
        this.comment_id = comment_id;
        this.author = author;
        this.comment_content = comment_content;
        this.create_time = create_time;
        this.likes = likes;
        this.post_id = post_id;
    }

    public Comment() {
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", author='" + author + '\'' +
                ", comment_content='" + comment_content + '\'' +
                ", create_time='" + create_time + '\'' +
                ", likes=" + likes +
                ", post_id='" + post_id + '\'' +
                '}';
    }
}


