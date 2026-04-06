package com.example.betting.member.repository;

import java.util.List;

import com.example.betting.member.vo.Member;

public interface MemberRepositoryCustom {
    List<Member> search(String username, Integer age);
}
