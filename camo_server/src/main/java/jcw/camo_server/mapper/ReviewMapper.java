package jcw.camo_server.mapper;

import jcw.camo_server.entity.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {

    List<Review> findAll();

}
