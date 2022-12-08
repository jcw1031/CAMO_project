package jcw.camo_server.service;

import jcw.camo_server.dto.cafe.CafeInfoDTO;
import jcw.camo_server.dto.cafe.CafeListDTO;
import jcw.camo_server.dto.cafe.CafeUpdateDTO;
import jcw.camo_server.entity.Cafe;
import jcw.camo_server.entity.Coupon;
import jcw.camo_server.entity.User;
import jcw.camo_server.mapper.CafeMapper;
import jcw.camo_server.mapper.CouponMapper;
import jcw.camo_server.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CafeService {

    private final CafeMapper cafeMapper;
    private final UserService userService;
    private final CouponMapper couponMapper;
    private final ReviewMapper reviewMapper;

    /**
     * 카페 등록
     */
    @Transactional
    public User register(final Cafe cafe) {
        Optional<Cafe> optionalCafe = cafeMapper.findById(cafe.getCafeId());
        if (optionalCafe.isPresent()) {
            log.info("이미 등록된 사업자번호입니다.");
            return null;
        }
        cafeMapper.cafeSave(cafe);
        Optional<User> optionalUser = userService.findById(cafe.getUserId());
        return userService.userRoleUpdate(optionalUser.get());
    }

    /**
     * 카페 리스트 조회
     */
    public List<CafeListDTO> cafeList() {
        return cafeMapper.findAll();
    }

    /**
     * 검색어가 이름에 포함된 카페 리스트
     */
    public List<CafeListDTO> findByName(final String name) {
        return cafeMapper.findByName(name);
    }

    /**
     * cafeId로 cafe 검색
     */
    /*@Transactional
    public Cafe findById(final String cafeId) {
        Optional<Cafe> optionalCafe = cafeMapper.findById(cafeId);
        if (optionalCafe.isPresent()) {
            Cafe cafe = optionalCafe.get();
            log.info("cafe find by id = {}", cafe);
            return cafe;
        } else {
            throw new IllegalArgumentException("해당 카페가 존재하지 않습니다.");
        }
    }*/

    @Transactional
    public CafeInfoDTO cafeInfoDetail(String cafeId, Long userId) {
        Optional<Cafe> optionalCafe = cafeMapper.findById(cafeId);
        Optional<Coupon> optionalCoupon = couponMapper.findCoupon(userId, cafeId);
        double avgRating = reviewMapper.cafeAvgRating(cafeId);
        int userStamp = 0;
        if (optionalCoupon.isPresent()) {
            userStamp = optionalCoupon.get().getCouponUserstamp();
        }
        if (optionalCafe.isPresent()) {
            Cafe cafe = optionalCafe.get();

            return CafeInfoDTO.builder()
                    .cafeId(cafe.getCafeId())
                    .cafeName(cafe.getCafeName())
                    .cafeAddress(cafe.getCafeAddress())
                    .cafePhone(cafe.getCafePhone())
                    .cafeIntroduce(cafe.getCafeIntroduce())
                    .cafeImage(cafe.getCafeImage())
                    .cafeReward(cafe.getCafeReward())
                    .cafeRewardstamp(cafe.getCafeRewardstamp())
                    .couponUserstamp(userStamp)
                    .avgRating(avgRating)
                    .build();

        } else {
            throw new IllegalArgumentException("해당 카페가 존재하지 않습니다.");
        }
    }

    @Transactional
    public Cafe findByUserId(final Long userId) {
        Optional<Cafe> optionalCafe = cafeMapper.findByUserId(userId);
        if (optionalCafe.isPresent()) {
            Cafe cafe = optionalCafe.get();
            log.info("cafe find by user's id = {}", cafe);
            return cafe;
        } else {
            throw new IllegalArgumentException("해당 회원의 카페가 존재하지 않습니다.");
        }
    }

    /**
     * 카페 정보 수정
     */
    @Transactional
    public Cafe cafeUpdate(final CafeUpdateDTO cafeUpdateDto) {
        Optional<Cafe> optionalCafe = cafeMapper.findById(cafeUpdateDto.getCafeId());
        if (optionalCafe.isPresent()) {
            Cafe oldCafe = optionalCafe.get();
            Cafe updatedCafe = Cafe.builder()
                    .cafeId(cafeUpdateDto.getCafeId())
                    .cafeName(cafeUpdateDto.getCafeName())
                    .cafeAddress(cafeUpdateDto.getCafeAddress())
                    .cafeIntroduce(cafeUpdateDto.getCafeIntroduce())
                    .cafePhone(cafeUpdateDto.getCafePhone())
                    .cafeReward(cafeUpdateDto.getCafeReward())
                    .cafeRewardstamp(cafeUpdateDto.getCafeRewardstamp())
                    .build();
            log.info("update cafe = {}", updatedCafe);

            cafeMapper.cafeUpdate(updatedCafe);


            /*cafe.setCafeName(cafeUpdateDto.getCafeName());
            cafe.setCafeAddress(cafeUpdateDto.getCafeAddress());
            cafe.setCafeIntroduce(cafeUpdateDto.getCafeIntroduce());
            cafe.setCafePhone(cafeUpdateDto.getCafePhone());
            cafe.setCafeReward(cafeUpdateDto.getCafeReward());
            cafe.setCafeRewardstamp(cafeUpdateDto.getCafeRewardstamp());*/

        }
        return cafeMapper.findById(cafeUpdateDto.getCafeId()).get();
    }

    public void cafeDelete(final String cafeId) {
        cafeMapper.delete(cafeId);
    }
}
