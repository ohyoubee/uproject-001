package com.example.uproject.controller;

import com.example.uproject.dto.MemberDTO;
import com.example.uproject.entity.Member;
import com.example.uproject.service.AdminService;
import com.example.uproject.service.MemberService;
import jakarta.validation.constraints.Past;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminController {
    private  final MemberService memberService;
    private final AdminService adminService;

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
            model.addAttribute("memberList", memberList);
        }
        return "/admin/list";
    }
    //회원 정보 삭제
    @GetMapping("/delete/{id}")
    public String deleteMemberById(@PathVariable int id) {
        adminService.deleteById(id);
        return "redirect:/list";  // 적절한 리다이렉션 경로를 사용
    }
    @GetMapping("/update/{id}")
//    public String update(@PathVariable int id , Model model){
    public String update(@PathVariable("id")int id , Model model){
    Member member = adminService.findById(id);
        model.addAttribute("member",member);
        return "/admin/memberUpdate";
    }
    @PostMapping("/update")
    public String updateMember(@ModelAttribute  MemberDTO memberDTO,Model model ) {
        MemberDTO member = adminService.updateMember(memberDTO);
        model.addAttribute("member",member);
        return "redirect:/list";
    }
}

