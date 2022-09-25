package jcw.CafeMenuApp.repository;

import jcw.CafeMenuApp.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id); //id로 회원 찾기
//    Optional<Member> findByName(String name); //이름으로 회원 찾기
    Optional<Member> findByEmail(String email); //Email로 회원 찾기
    List<Member> findAll(); //저장된 모든 회원 반환
}
