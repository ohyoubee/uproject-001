package com.example.uproject.controller;

import com.example.uproject.dto.MemberDTO;
import com.example.uproject.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    //회원가입
    @GetMapping("join")
    public String showJoinPage(Model model) {
        model.addAttribute("memberDTO",new MemberDTO());
        return "/member/join";
    }

    @PostMapping("join")
    public String joinMethod(@ModelAttribute MemberDTO memberDTO, Model model) {
        memberService.insertMember(memberDTO);
        return "redirect:/login"; //회원 가입 후 로그인으로 리다이렉트
    }

    //로그인
    @GetMapping("login")
    public String showLogin(Model model){

        return "/member/login";
    }
}