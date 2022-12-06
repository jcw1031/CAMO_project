package jcw.camo_server.mapper;

import jcw.camo_server.dto.cafe.CafeListDTO;
import jcw.camo_server.entity.Cafe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CafeMapper {

    /**
     * Cafe 저장
     */
    void cafeSave(Cafe cafe);

    /**
     * 카페 리스트
     */
    List<CafeListDTO> findAll();

    /**
     * 이름으로 cafe 검색
     */
    List<CafeListDTO> findByName(@Param("name") String cafeName);

    /**
     * userId로 cafe 검색
     */
    Optional<Cafe> findByUserId(@Param("id") Long userId);

    /**
     * cafeId로 cafe 검색
     */
    Optional<Cafe> findById(@Param("id") String cafeId);

    void cafeUpdate(Cafe cafe);

    void delete(@Param("id") String cafeId);
}
