package com.ssg.gallery.member.repository;

import com.ssg.gallery.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    
    // null 방지하기 위해 Optional 사용
    // id와 패스워드로 회원 정보를 조회
    Optional<Member> findByLoginIdAndLoginPw(String loginId, String loginPw);
}
