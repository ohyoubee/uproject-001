package com.example.uproject.dto;

import com.example.uproject.entity.Member;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class MemberDTO {

    private int id;
    private String name;
    private String nickname;
    private String loginId;
    private String password;
    private String email;
    private String phone;
    private LocalDateTime joinDate;

    public Member memberEntity() {
        return Member.builder()
                .id(id)
                .name(name)
                .nickname(nickname) // 수정: nickname 추가
                .loginId(loginId)
                .password(password)
                .email(email)
                .phone(phone)
                .joinDate(joinDate)
                .build();
    }

    public static MemberDTO toMemberDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId()); // 수정: getId() 사용
        memberDTO.setName(member.getName()); // 수정: getName() 사용
        memberDTO.setNickname(member.getNickname()); // 추가: getNickname() 사용
        memberDTO.setLoginId(member.getLoginId());
        memberDTO.setPassword(member.getPassword());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setPhone(member.getPhone());
        memberDTO.setJoinDate(member.getJoinDate());
        return memberDTO;
    }
}
