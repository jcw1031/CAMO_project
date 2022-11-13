package jcw.camoServer.controller;

import jcw.camoServer.entity.Coupon;
import jcw.camoServer.service.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @PostMapping("")
    public void stamp(@RequestBody Coupon coupon) {

    }
}
