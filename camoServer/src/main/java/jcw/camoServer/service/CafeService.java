package jcw.camoServer.service;

import jcw.camoServer.entity.Cafe;
import jcw.camoServer.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CafeService {

    @Autowired
    CafeRepository cafeRepository;

    /**
     * 카페 등록
     */
    public Cafe register(Cafe cafe) {
        validateDuplicateCafe(cafe);

        return cafeRepository.save(cafe);
    }

    /**
     * 중복 검사
     */
    private void validateDuplicateCafe(Cafe cafe) {
        cafeRepository.findById(cafe.getCafeId()) //null이 아니라 값이 있으면 로직이 동작 (Optional이기 때문에 가능)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 등록된 카페입니다.");
                });
    }

    /**
     * 카페 리스트
     */
    public List<Cafe> findAll(){
        return cafeRepository.findAll();
    }

    /**
     * id를 통해 카페 검색
     */
    public Optional<Cafe> findById(Long id){
        return cafeRepository.findById(id);
    }

    /**
     * name을 포함한 이름을 가진 카페 검색
     */
    public Optional<Cafe> findByName(String name){
        return cafeRepository.findByCafeNameContains(name);
    }
}
