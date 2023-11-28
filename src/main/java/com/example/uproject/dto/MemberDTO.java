package com.example.uproject.dto;

import com.example.uproject.entity.Member;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Setter
@Getter
public class MemberDTO {

    private int id;

    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    private LocalDateTime joinDate;

    public Member memberEntity() {
        return Member.builder()
                .id(id)
                .name(name)
                .username(username)
                .password(password)
                .email(email)
                .phone(phone)
                .joinDate(joinDate)
                .build();
    }
}
