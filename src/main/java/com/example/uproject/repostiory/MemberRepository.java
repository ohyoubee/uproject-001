package com.example.uproject.repostiory;

import com.example.uproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    //db의 loginId 컬럼 찾기
    //Optional 는 null 방지
    Optional<Member> findByLoginId(String LoginId);
}
