package jcw.camo_server.controller;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import jcw.camo_server.service.CouponService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;


}
