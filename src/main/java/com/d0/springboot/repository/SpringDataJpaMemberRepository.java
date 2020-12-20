package com.d0.springboot.repository;

import com.d0.springboot.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL select m from Member m where name = ?
    @Override
    Optional<Member> findByName(String name);
}
