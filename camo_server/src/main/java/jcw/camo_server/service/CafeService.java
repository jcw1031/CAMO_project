package jcw.camo_server.service;

import jcw.camo_server.dto.cafe.CafeDeleteDTO;
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
        log.info("cafe search = {}", name);
        return cafeMapper.findByName(name);
    }

    /**
     * 카페 상세 정보 조회
     * @param cafeId
     * @param userId
     * @return
     */
    @Transactional
    public CafeInfoDTO cafeInfoDetail(String cafeId, Long userId) {
        Optional<Cafe> optionalCafe = cafeMapper.findById(cafeId);
        Optional<Coupon> optionalCoupon = couponMapper.findCoupon(userId, cafeId);
        Optional<Double> optionalDouble = reviewMapper.cafeAvgRating(cafeId);
        int userStamp = 0;
        double avgRating;

        if (optionalDouble.isPresent()) {
            avgRating = optionalDouble.get();
        } else{
            avgRating = 0;
        }

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
        }
        return cafeMapper.findById(cafeUpdateDto.getCafeId()).get();
    }

    /**
     * 카페 삭제
     * @param deleteDto 삭제할 카페의 cafeId와 사장의 password
     * @return role 업데이트 된 user 정보
     */
    public User cafeDelete(final CafeDeleteDTO deleteDto) {
        Optional<Cafe> optionalCafe = cafeMapper.findById(deleteDto.getCafeId());
        Cafe cafe;
        if (optionalCafe.isPresent()) {
            cafe = optionalCafe.get();
        } else {
            throw new IllegalArgumentException("카페 삭제 오류!(사업자번호 오류)");
        }
        Optional<User> optionalUser = userService.findById(cafe.getUserId());
        User user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new IllegalArgumentException("카페 사장 정보 불러오기 실패");
        }

        if (deleteDto.getUserPassword().equals(user.getPassword())) {
            log.info("카페 삭제 = {}", cafe);
            cafeMapper.delete(cafe);
        } else {
            throw new IllegalArgumentException("비밀번호 불일치! 삭제 실패");
        }

        return userService.userRoleUpdate(user);
    }
}
