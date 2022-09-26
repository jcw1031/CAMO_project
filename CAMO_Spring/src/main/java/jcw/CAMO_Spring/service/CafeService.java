package jcw.CAMO_Spring.service;

import jcw.CAMO_Spring.domain.Cafe;
import jcw.CAMO_Spring.repository.CafeRepository;

import java.util.Optional;

public class CafeService {
    private CafeRepository cafeRepository;

    public CafeService(CafeRepository cafeRepository){
        this.cafeRepository = cafeRepository;
    }

    /**
     * 카페 등록
     * @param cafe
     * @return Long
     */
    public Long join(Cafe cafe){
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        */
        //위의 코드도 가능하지만 아래가 깔끔하게 가능

        validateDuplicateCafe(cafe);

        cafeRepository.save(cafe);
        return cafe.getCafeId();
    }

    /**
     * 카페 중복 등록 방지
     * @param cafe
     */
    private void validateDuplicateCafe(Cafe cafe){
        cafeRepository.findById(cafe.getCafeId()) //null이 아니라 값이 있으면 로직 동작
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 등록된 카페입니다.");
                });
    }

    /**
     * 카페ID를 통해 카페 조회
     * @param cafeId
     * @return Optional
     */
    public Optional<Cafe> findOne(Long cafeId){
        return cafeRepository.findById(cafeId);
    }
}
