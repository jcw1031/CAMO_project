package jcw.CafeMenuApp.service;

import jcw.CafeMenuApp.domain.Member;
import jcw.CafeMenuApp.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memoryMemberReopsitory;

    @BeforeEach
    public void beforeEach(){
        memoryMemberReopsitory = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberReopsitory);
    }

    @AfterEach
    public void afterEach(){
        memoryMemberReopsitory.clearStore();
    }

    @Test
    void join(){
        //given
        Member member = new Member();
        member.setName("test");
        member.setEmail("test@gmail.com");
        member.setPassword("test1234");
        member.setRight(true);
        member.setPhoneNumber("010-1234-5678");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getEmail()).isEqualTo(findMember.getEmail());
    }
}
