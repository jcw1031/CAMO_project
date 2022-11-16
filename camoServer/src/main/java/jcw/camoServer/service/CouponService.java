package jcw.camoServer.service;

import jcw.camoServer.entity.Coupon;
import jcw.camoServer.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    @Autowired
    CouponRepository couponRepository;

    public List<Coupon> findByMemberId(Long memberId) {
        return couponRepository.findByMemberId(memberId);
    }
}
