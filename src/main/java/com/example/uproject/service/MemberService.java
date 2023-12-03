package com.example.uproject.service;

import com.example.uproject.dto.MemberDTO;
import com.example.uproject.entity.Member;
import com.example.uproject.repostiory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;



    //회원 등록
    public MemberDTO insertMember(MemberDTO memberDTO) {
        Member member = new Member();

        member.setName(memberDTO.getName());
        member.setNickname(memberDTO.getNickname());
        member.setLoginId(memberDTO.getLoginId());
        member.setPassword(memberDTO.getPassword());
        member.setEmail(memberDTO.getEmail());
        member.setPhone(memberDTO.getPhone());

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
        return memberDTO;
    }

    public MemberDTO Login(MemberDTO memberDTO) {
        Optional<Member> findLoginId = memberRepository.findByLoginId(memberDTO.getLoginId());
        if (findLoginId.isPresent()) {
                //해당 loginId를 갖은 회원 정보가있음
             Member member = findLoginId.get();
             if (member.getPassword(). equals(memberDTO.getPassword())){
                 //비밀번호가 일치
                 MemberDTO dto = MemberDTO.toMemberDTO(member);
                 return dto;
             }else {
                 return null;
             }
        }else {
            //조회결과 없음
        }
        return null;
    }
}


