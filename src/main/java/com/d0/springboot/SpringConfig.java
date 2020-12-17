package com.d0.springboot;

import com.d0.springboot.repository.MemberRepository;
import com.d0.springboot.repository.MemoryMemberRepository;
import com.d0.springboot.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
