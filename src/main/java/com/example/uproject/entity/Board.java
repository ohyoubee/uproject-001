package com.example.uproject.entity;


import com.example.uproject.config.Role;
import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
public class Board {
    //글번호
    @Id
    @Column(name = "num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;

    //제목
    @Column(name = "title", nullable = false)
    private String title;

    //내용
    @Column(name = "content", nullable = false)
    private String content;

    //글 종류(카테고리)
    @Column(name = "category")
    private String category;

    //글 작성 시간
    @Column(name = "createTime")
    private LocalDateTime createTime;

    //조회수
    @Column(name = "viewCount")
    private int viewCount;

    //좋아요수
    @Column(name = "likeCount")
    private int likeCount;

    //마지막 수정 시간
    @Column(name = "update_time")
    private LocalDateTime updateTime;

}

