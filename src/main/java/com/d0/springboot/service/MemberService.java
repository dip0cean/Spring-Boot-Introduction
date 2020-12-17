package com.d0.springboot.service;

import com.d0.springboot.domain.Member;
import com.d0.springboot.repository.MemberRepository;
import com.d0.springboot.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository memoryMemberRepository) {
        this.repository = memoryMemberRepository;
    }

    // 회원 가입
    public Long join(Member member) {
        validateDuplicateMember(member);
        repository.save(member);
        return member.getId();
    }

    // 회원 중복 검사
    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return repository.findAll();
    }

    // 단일 조회 -> 아이디를 이용해서
    public Optional<Member> findOne(Long memberId) {
        return repository.findById(memberId);
    }
}
