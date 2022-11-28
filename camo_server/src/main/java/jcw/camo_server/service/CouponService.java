package jcw.camo_server.service;

import jcw.camo_server.mapper.CouponMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponMapper couponMapper;
}
