package jcw.CafeMenuApp.repository;

import jcw.CafeMenuApp.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Long sequence = 10000L; //고유 회원번호
    private static Map<Long, Member> store = new HashMap<>(); //회원을 저장할 저장소

    @Override
    public Member save(Member member) {
        member.setMemberId(sequence++);
        store.put(member.getMemberId(), member);
        return store.get(member.getMemberId());
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    /*@Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //람다식 이용. 하나라도 찾으면 return. 끝까지 없으면 null return
                .filter(member -> member.getName().equals(name))
                .findAny();
    }*/

    @Override
    public Optional<Member> findByEmail(String email){
        return store.values().stream() //람다식 이용. 하나라도 찾으면 return. 끝까지 없으면 null return
                .filter(member -> member.getEmail().equals(email))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
