package com.example.uproject.service;

import com.example.uproject.dto.MemberDTO;
import com.example.uproject.entity.Member;
import com.example.uproject.repostiory.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdminService {
    private final MemberRepository memberRepository;
    //회원 정보 다 가져오기
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    //회원 정보 삭제
    public void deleteById(int id){
        memberRepository.deleteById(id);
    }
    public Member findById(int id){
        memberRepository.findById(id);
        return memberRepository.findById(id);
    }
    public MemberDTO updateMember(MemberDTO memberDTO) {
        Member member = memberRepository.findById(memberDTO.getId());
        member.setId(memberDTO.getId());
        member.setLoginId(memberDTO.getLoginId());
        member.setPassword(memberDTO.getPassword());
        member.setName(memberDTO.getName());
        member.setNickname(memberDTO.getNickname());
        member.setEmail(memberDTO.getEmail());
        member.setPhone(memberDTO.getPhone());

        // DB에 저장
        memberRepository.save(member);

        // Member를 MemberDTO로 변환하여 반환
        return memberDTO;
    }
}