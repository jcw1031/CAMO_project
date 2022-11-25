package jcw.camo_server.service;

import jcw.camo_server.dto.CafeListDto;
import jcw.camo_server.dto.CafeUpdateDto;
import jcw.camo_server.entity.Cafe;
import jcw.camo_server.entity.User;
import jcw.camo_server.mapper.CafeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CafeService {

    private final CafeMapper cafeMapper;
    private final UserService userService;

    /**
     * 카페 등록
     */
    @Transactional
    public Cafe register(Cafe cafe) {
        Optional<Cafe> optionalCafe = cafeMapper.findById(cafe.getCafeId());
        if (optionalCafe.isPresent()) {
            log.info("이미 등록된 사업자번호입니다.");
            return null;
        }
        cafeMapper.cafeSave(cafe);
        Optional<User> optionalUser = userService.findById(cafe.getUserId());
        userService.userRoleUpdate(optionalUser.get());
        return cafe;
    }

    /**
     * 카페 리스트 조회
     */
    public List<CafeListDto> cafeList() {
        return cafeMapper.findAll();
    }

    /**
     * 검색어가 이름에 포함된 카페 리스트
     */
    public List<CafeListDto> findByName(String name) {
        return cafeMapper.findByName(name);
    }

    /**
     * 카페 정보 수정
     */
    @Transactional
    public Cafe cafeUpdate(CafeUpdateDto cafeUpdateDto) {
        Optional<Cafe> optionalCafe = cafeMapper.findById(cafeUpdateDto.getCafeId());
        Cafe cafe = optionalCafe.get();
        cafe.setCafeName(cafeUpdateDto.getCafeName());
        cafe.setCafeAddress(cafeUpdateDto.getCafeAddress());
        cafe.setCafeIntroduce(cafeUpdateDto.getCafeIntroduce());
        cafe.setCafePhone(cafeUpdateDto.getCafePhone());
        cafe.setCafeReward(cafeUpdateDto.getCafeReward());
        cafe.setCafeRewardstamp(cafeUpdateDto.getCafeRewardstamp());
        cafeMapper.cafeUpdate(cafe);
        return cafeMapper.findById(cafeUpdateDto.getCafeId()).get();
    }

    public void cafeDelete(String cafeId) {
        cafeMapper.delete(cafeId);
    }
}
