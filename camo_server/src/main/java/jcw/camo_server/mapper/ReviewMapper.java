package jcw.camo_server.mapper;

import jcw.camo_server.dto.review.CafeReviewListDTO;
import jcw.camo_server.dto.review.UserReviewListDTO;
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

    List<CafeReviewListDTO> findByCafeId(@Param("cafeId") String cafeId);

    List<UserReviewListDTO> findByUserId(@Param("userId") Long userId);

    Optional<Double> cafeAvgRating(@Param("cafeId") String cafeId);

    void reviewDelete(Review review);

}
