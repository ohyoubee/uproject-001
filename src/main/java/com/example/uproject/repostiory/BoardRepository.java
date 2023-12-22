package com.example.uproject.repostiory;

import com.example.uproject.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Integer> {
//    Board findALl(int num);

}
