package com.ohgiraffers.policykorea.board;

public class Post {
    private int post_id;
    private String title;
    private String content;
    private String author;
    private String location;
    private String gender;
    private String start_time;
    private String end_time;
    private String status;
    private int likes;
    private int reports;

    private String url;

    public Post() {
    }

    public Post(int post_id, String title, String content, String author, String location, String gender, String start_time, String end_time, String status, int likes, int reports, String url) {
        this.post_id = post_id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.location = location;
        this.gender = gender;
        this.start_time = start_time;
        this.end_time = end_time;
        this.status = status;
        this.likes = likes;
        this.reports = reports;
        this.url = url;
    }
// Getter와 Setter 메서드 생략


    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
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

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", location='" + location + '\'' +
                ", gender='" + gender + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", status='" + status + '\'' +
                ", likes=" + likes +
                ", reports=" + reports +
                ", url='" + url + '\'' +
                '}';
    }
}