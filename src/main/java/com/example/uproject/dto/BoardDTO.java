package com.example.uproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDTO {
    private int num;
    private String title;
    private String content;
    private String category;
    private int viewCount;
    private int likeCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
