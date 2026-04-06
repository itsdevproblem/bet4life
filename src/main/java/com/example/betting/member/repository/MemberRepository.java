package com.example.betting.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.betting.member.vo.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    
}
