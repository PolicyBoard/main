package com.ohgiraffers.policykorea.board;

public class Post {
    private int postId;
    private String title;
    private String content;
    private String author;
    private String location;
    private String gender;
    private String startTime;
    private String endTime;
    private String status;
    private int likes;
    private int reports;

    // Getter와 Setter 메서드 생략

    public Post(int postId, String title, String content, String author, String location, String gender, String startTime, String endTime, String status, int likes, int reports) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.author = author;
        this.location = location;
        this.gender = gender;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.likes = likes;
        this.reports = reports;
    }

    public int getPostId() {
        System.out.println();
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getReports() {
        return reports;
    }

    public void setReports(int reports) {
        this.reports = reports;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", location='" + location + '\'' +
                ", gender='" + gender + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", status='" + status + '\'' +
                ", likes=" + likes +
                ", reports=" + reports +
                '}';
    }
}