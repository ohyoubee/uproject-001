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
@Table(name = "member")
public class Member {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //실명
    @Column(name = "name", nullable = false)
    private String name;

    //닉네임
    @Column(name = "nickname", nullable = false)
    private String nickname;

    //아이디
    @Column(name = "loginId", nullable = false)
    private String loginId;

    //비밀번호
    @Column(name = "password", nullable = false)
    private String password;

    //이메일
    @Column(name = "email", nullable = false)
    private String email;

    //휴대폰번호
    @Column(name = "phone", nullable = false)
    private String phone;

    //가입 시간
    @Column(name = "joinDate")
    private LocalDateTime joinDate;


    //Security를 위한 role 부여
    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean enabled;
}

