package com.ohgiraffers.policykorea.mainpage.dto;

public class PostDTO {

    private int postId;
    private String title;
    private String content;
    private String region;
    private String gender;
    private String startDate;
    private String endDate;
    private String status;
    private int commentsCount;
    private String imageUrl;

    public PostDTO() {
    }

    public PostDTO(int postId, String title, String content, String region, String gender, String startDate, String endDate, String status, int commentsCount, String imageUrl) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.region = region;
        this.gender = gender;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.commentsCount = commentsCount;
        this.imageUrl = imageUrl;
    }

    public int getPostId() {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", region='" + region + '\'' +
                ", gender='" + gender + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", status='" + status + '\'' +
                ", commentsCount=" + commentsCount +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

}
