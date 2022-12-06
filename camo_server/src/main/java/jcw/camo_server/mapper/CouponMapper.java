package jcw.camo_server.mapper;

import jcw.camo_server.dto.coupon.CouponListDTO;
import jcw.camo_server.entity.Coupon;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CouponMapper {

    void save(Coupon coupon);

    void updateCoupon(Coupon coupon);

    Optional<Coupon> findCoupon(@Param("userId") Long userId, @Param("cafeId") String cafeId);

    List<CouponListDTO> findByUser(@Param("userId") Long userId);
}
