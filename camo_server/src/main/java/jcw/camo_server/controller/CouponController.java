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

    /**
     * 사용자별 쿠폰 리스트
     * @param userId 쿠폰 리스트를 불러올 userId
     * @return userId를 가진 사용자의 쿠폰 리스트
     */
    @GetMapping("/user/{id}")
    public List<CouponListDTO> userCouponList(@PathVariable("id") Long userId) {
        return couponService.userCouponList(userId);
    }

    /**
     * 쿠폰 사용
     * @param cafeId 카페의 cafeId
     * @param userId 사용자의 userId
     */
    @PutMapping("/use")
    public void couponUse(@RequestParam("cafeId") String cafeId, @RequestParam("userId") Long userId) {
        couponService.useCoupon(cafeId, userId);
    }

    @GetMapping("/list")
    public List<Coupon> couponList() {
        return couponService.couponList();
    }
}
