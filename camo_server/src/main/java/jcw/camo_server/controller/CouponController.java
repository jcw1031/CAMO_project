package jcw.camo_server.controller;

import jcw.camo_server.dto.cafe.CafeListDTO;
import jcw.camo_server.dto.coupon.CouponDTO;
import jcw.camo_server.dto.coupon.CouponListDTO;
import jcw.camo_server.entity.Coupon;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import jcw.camo_server.service.CouponService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void couponPayment(@RequestBody CouponDTO couponDto) {
        couponService.giveCoupon(couponDto);
    }

    @GetMapping("/user/{id}")
    public List<CouponListDTO> userCouponList(@PathVariable("id") Long userId) {
        return couponService.userCouponList(userId);
    }

    @GetMapping("/list")
    public List<Coupon> couponList() {
        return couponService.couponList();
    }
}
