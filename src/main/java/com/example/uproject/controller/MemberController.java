package com.example.uproject.controller;

import com.example.uproject.dto.MemberDTO;
import com.example.uproject.repostiory.MemberRepository;
import com.example.uproject.service.MemberService;
import jakarta.servlet.http.HttpSession;
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
    private final MemberRepository memberRepository;

    @GetMapping("home")
    public String firstHome() {
        return "/member/home";
    }

    @GetMapping("main")
    public String main(){
        return "/main/main";
    }

    //회원가입
    @GetMapping("join")
    public String showJoinPage(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "/member/join";
    }

    @PostMapping("join")
    public String joinMethod(@ModelAttribute MemberDTO memberDTO) {
        memberService.insertMember(memberDTO);
        return "redirect:/home"; //회원 가입 후 login 리다이렉트
    }

    //로그인
    @GetMapping("/login")
    public String loginForm() {
        return "/member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO , HttpSession httpSession) {

        MemberDTO loginResult = memberService.Login(memberDTO);

        if (loginResult != null) {
// Login 성공
            httpSession.setAttribute("loginId",loginResult.getLoginId());
            return
                    "redirect:/main";
        } else {
// Login 실패
            return "/member/login";
        }
    }
}
