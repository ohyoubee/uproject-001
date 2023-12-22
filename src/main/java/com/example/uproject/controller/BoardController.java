package com.example.uproject.controller;


import com.example.uproject.service.BoardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;




    //게시판 테스트용도 간단한.
    @GetMapping("BoardListTest")
    public String boardList(){

        return "/board/boardListTest";
    }
}
