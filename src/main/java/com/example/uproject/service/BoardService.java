package com.example.uproject.service;


import com.example.uproject.entity.Board;
import com.example.uproject.repostiory.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    List<Board> getNumFindAll(){
        return boardRepository.findAll();
    }
}
