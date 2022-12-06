package jcw.camo_server.mapper;

import jcw.camo_server.entity.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReviewMapper {

    void reviewSave(Review review);

    List<Review> findAll();

    Optional<Review> findByReviewId(@Param("reviewId") Long reviewId);

    List<Review> findByCafeId(@Param("cafeId") String cafeId);

    List<Review> findByUserId(@Param("userId") Long userId);

    void reviewDelete(Review review);

}
