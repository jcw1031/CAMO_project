package jcw.camo_server.service;

import jcw.camo_server.dto.coupon.CouponDto;
import jcw.camo_server.entity.Coupon;
import jcw.camo_server.mapper.CouponMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CouponService {

    private final CouponMapper couponMapper;

    @Transactional
    public void giveCoupon(CouponDto couponDto) {
        Optional<Coupon> optionalCoupon = couponMapper.findCoupon(couponDto.getUserId(), couponDto.getCafeId());
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
                    .userId(couponDto.getUserId())
                    .cafeId(couponDto.getCafeId()).build());
            log.info("첫 방문! 쿠폰 지급");
        }
    }
}
