package jcw.CAMO_Spring;

import jcw.CAMO_Spring.repository.CafeRepository;
import jcw.CAMO_Spring.repository.MemberRepository;
import jcw.CAMO_Spring.repository.MemoryCafeRepository;
import jcw.CAMO_Spring.repository.MemoryMemberRepository;
import jcw.CAMO_Spring.service.CafeService;
import jcw.CAMO_Spring.service.MemberService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean //스프링 빈에 등록
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public CafeService cafeService(){
        return new CafeService((cafeRepository()));
    }

    @Bean
    public CafeRepository cafeRepository(){
        return new MemoryCafeRepository();
    }
}
