package com.ohgiraffers.policykorea.DTO;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class postDTO {
    private int postId;
    private String title;
    private String content;
    private String author;
    private String location;
    private String gender;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private int likes;
    private int reports;
}
