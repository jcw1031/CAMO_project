package jcw.camo_server.service;

import jcw.camo_server.dto.coupon.CouponDTO;
import jcw.camo_server.dto.coupon.CouponListDTO;
import jcw.camo_server.entity.Cafe;
import jcw.camo_server.entity.Coupon;
import jcw.camo_server.entity.User;
import jcw.camo_server.mapper.CafeMapper;
import jcw.camo_server.mapper.CouponMapper;
import jcw.camo_server.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CouponService {

    private final CouponMapper couponMapper;
    private final CafeMapper cafeMapper;
    private final UserMapper userMapper;

    /**
     * 쿠폰 적립
     * @param couponDto
     */
    @Transactional
    public void giveCoupon(CouponDTO couponDto) {
        Optional<User> optionalUser = userMapper.findByEmail(couponDto.getUserEmail());
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new IllegalArgumentException("존재하지 않는 회원입니다!");
        }
        Optional<Coupon> optionalCoupon = couponMapper.findCoupon(user.getUserId(), couponDto.getCafeId());
        if (optionalCoupon.isPresent()) {
            Coupon coupon = optionalCoupon.get();
            int stamp = coupon.getCouponUserstamp() + couponDto.getStampQuantity();
            couponMapper.updateCoupon(Coupon.builder()
                    .couponId(coupon.getCouponId())
                    .couponUserstamp(stamp).build());
            log.info("스탬프 지급");
        } else {
            couponMapper.save(Coupon.builder()
                    .couponUserstamp(couponDto.getStampQuantity())
                    .userId(user.getUserId())
                    .cafeId(couponDto.getCafeId()).build());
            log.info("첫 방문! 쿠폰 지급");
        }
    }

    @Transactional
    public List<CouponListDTO> userCouponList(Long userId) {
        return couponMapper.findByUser(userId);
    }

    /**
     * 쿠폰 사용
     * @param cafeId
     * @param userEmail
     */
    @Transactional
    public void useCoupon(String cafeId, String userEmail) {
        Optional<User> optionalUser = userMapper.findByEmail(userEmail);
        User user = null;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new IllegalArgumentException("존재하지 않는 회원입니다!");
        }
        Optional<Coupon> optionalCoupon = couponMapper.findCoupon(user.getUserId(), cafeId);
        Optional<Cafe> optionalCafe = cafeMapper.findById(cafeId);
        if (optionalCoupon.isPresent() && optionalCafe.isPresent()) {
            Coupon coupon = optionalCoupon.get();
            Cafe cafe = optionalCafe.get();

            if (coupon.getCouponUserstamp() >= cafe.getCafeRewardstamp()) {
                couponMapper.updateCoupon(Coupon.builder()
                        .couponId(coupon.getCouponId())
                        .couponUserstamp(coupon.getCouponUserstamp() - cafe.getCafeRewardstamp())
                        .build());
                log.info("쿠폰 사용!! = {}", coupon);
            } else {
                throw new IllegalArgumentException("쿠폰이 부족합니다!");
            }
        } else {
            throw new IllegalArgumentException("잘못된 요청입니다!");
        }
    }

    public List<Coupon> couponList() {
        return couponMapper.findAll();
    }
}
