package jcw.CAMO_Server.service;

import jcw.CAMO_Server.entity.Member;
import jcw.CAMO_Server.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public boolean join(Member member){
        validateDuplicateMember(member);

        memberRepository.save(member);
        return true;
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail()) //null이 아니라 값이 있으면 로직이 동작 (Optional이기 때문에 가능)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 사용 중인 이메일입니다.");
                });
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findById(int id){
        Optional<Member> member = 
    }
}