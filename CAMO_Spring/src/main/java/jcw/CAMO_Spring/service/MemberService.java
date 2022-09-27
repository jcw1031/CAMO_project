package jcw.CAMO_Spring.service;

import jcw.CAMO_Spring.domain.Member;
import jcw.CAMO_Spring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Service
public class MemberService {
    private MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository) { //Dependency Injection
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     * @param member
     * @return Long
     */
    public Long join(Member member){
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        */
        //위의 코드도 가능하지만 아래가 깔끔하게 가능

        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getMemberId();
    }

    /** 이메일 중복 방지
     *
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail()) //null이 아니라 값이 있으면 로직이 동작 (Optional이기 때문에 가능)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 사용 중인 이메일입니다.");
                });
    }

    /** email을 통해 회원 조회
     *
     * @param memberEmail
     * @return Optional
     */
    public Optional<Member> findOneByEamil(String memberEmail){
        return memberRepository.findByEmail(memberEmail);
//        return memberRepository.findById(memberId);
    }

    /**
     * id를 통해 회원 조회
     * @param memberId
     * @return Optional
     */
    public Optional<Member> findOneById(Long memberId){
        return memberRepository.findById(memberId);
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    /**
     * 회원 탈퇴
     * @param member
     * @return boolean
     */
    public boolean delete(Member member){
        memberRepository.remove(member.getMemberId());
        return true;
    }
}
