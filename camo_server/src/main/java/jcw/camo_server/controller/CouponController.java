package jcw.camo_server.controller;

import jcw.camo_server.dto.coupon.CouponDto;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import jcw.camo_server.service.CouponService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;

    /**
     * 쿠폰 지급
     * @param couponDto 스탬프 수량과 cafeId, userId
     */
    @PostMapping("")
    public void couponPayment(@RequestBody CouponDto couponDto) {
        couponService.giveCoupon(couponDto);
    }
}
