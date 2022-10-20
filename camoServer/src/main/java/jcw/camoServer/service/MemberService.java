package jcw.camoServer.service;

import jcw.camoServer.entity.Member;
import jcw.camoServer.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Member join(Member member){
        validateDuplicateMember(member);

        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail()) //null이 아니라 값이 있으면 로직이 동작 (Optional이기 때문에 가능)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 사용 중인 이메일입니다.");
                });
    }

    public List<Member> findAll(){
        System.out.println("asdf");
        return memberRepository.findAll();
    }

    public Optional<Member> findById(long id){
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            return member;
        }
        System.out.println("존재하지 않습니다.");
        return null;
    }

    public Optional<Member> findByEmail(String email){
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent()) {
            return member;
        }
        System.out.println("존재하지 않습니다.");
        return null;
    }
}
