package jcw.camo_server.mapper;

import jcw.camo_server.entity.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {

    Review reviewSave(Review review);

    List<Review> findAll();

    List<Review> findByCafeId(@Param("cafeId") String cafeId);

    List<Review> findByUserId(@Param("userId") Long userId);

}
