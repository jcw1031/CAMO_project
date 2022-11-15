package jcw.camoServer.controller;

import jcw.camoServer.entity.Coupon;
import jcw.camoServer.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    /**
     * 쿠폰 적립
     */
    @PostMapping("")
    public void stamp(@RequestBody Coupon coupon) {

    }

    /**
     * 회원의 쿠폰 리스트
     */
    @GetMapping("/list/{id}")
    public List<Coupon> usersCouponList(@PathVariable("id") Long memberId) {
        return couponService.findByMemberId(memberId);
    }
}
