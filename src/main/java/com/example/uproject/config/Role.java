package com.example.uproject.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public enum Role implements Serializable {
    //SpringSecurity 를 위한 권한 부여
    ADMIN, //어드민 권한
    USER; //유저 권한
}
