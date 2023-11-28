package com.example.uproject.service;

import com.example.uproject.dto.MemberDTO;
import com.example.uproject.entity.Member;
import com.example.uproject.repostiory.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    // 회원가입
    public MemberDTO insertMember(MemberDTO memberInfo) {
        Member member = new Member();

        member.setName(memberInfo.getName());
        member.setUsername(memberInfo.getUsername());
        member.setPassword(memberInfo.getPassword());
        member.setEmail(memberInfo.getEmail());
        member.setPhone(memberInfo.getPhone());
        // 현재 날짜와 시간을 얻기
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = now.format(formatter);
        // String으로 변환한 값을 LocalDateTime으로 변경
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedDateTime, formatter);
        // member의 joinDate에 설정
        member.setJoinDate(parsedDateTime);

        // DB에 저장
        memberRepository.save(member);

        // Member를 MemberDTO로 변환하여 반환
        return memberInfo;
    }

}
