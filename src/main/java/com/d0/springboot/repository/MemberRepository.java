package com.d0.springboot.repository;

import com.d0.springboot.domain.Member;

import java.util.*;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
