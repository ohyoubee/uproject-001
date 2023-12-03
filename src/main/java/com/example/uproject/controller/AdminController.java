package com.example.uproject.controller;

import com.example.uproject.dto.MemberDTO;
import com.example.uproject.entity.Member;
import com.example.uproject.service.AdminService;
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
    @Autowired
    AdminService adminService;
    //어드민
    @GetMapping("admin")
    public String adminPage(){
        return "/admin/admin";
    }

    //회원정보 모두 불러오기
    @GetMapping("/list")
    public String findMemberList(Model model){
        adminService.getAllMembers();{
            List<Member> memberList = adminService.getAllMembers();
            model.addAttribute("memberList",memberList);
        }
        return "/admin/list";
    }
}
