package com.example.uproject.controller;

import com.example.uproject.dto.MemberDTO;
import com.example.uproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    @Autowired
    MemberService memberService;
    //어드민
    @GetMapping("admin")
    public String adminPage(){
        return "/admin/admin";
    }
    @GetMapping("/list")
    public String findMemberList(Model model){
        memberService.findMemberList();{
            List<MemberDTO> memberDTOList = memberService.findMemberList();
            model.addAttribute("memberDTOList",memberDTOList);
        }
        return "/admin/list";
    }
}
