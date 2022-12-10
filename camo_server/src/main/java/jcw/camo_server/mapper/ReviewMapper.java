package jcw.camo_server.mapper;

import jcw.camo_server.dto.review.ReviewListDTO;
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

    List<ReviewListDTO> findByCafeId(@Param("cafeId") String cafeId);

    List<Review> findByUserId(@Param("userId") Long userId);

    Optional<Double> cafeAvgRating(@Param("cafeId") String cafeId);

    void reviewDelete(Review review);

}
