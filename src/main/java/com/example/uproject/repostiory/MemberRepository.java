package com.example.uproject.repostiory;

import com.example.uproject.dto.MemberDTO;
import com.example.uproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findById(int id); //id로 유저 조회
}
