package jcw.CafeMenuApp;

import jcw.CafeMenuApp.repository.MemberRepository;
import jcw.CafeMenuApp.repository.MemoryMemberRepository;
import jcw.CafeMenuApp.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean //스프링 빈에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean //스프링 빈에 등록
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
