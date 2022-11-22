package jcw.camo_server.mapper;

import jcw.camo_server.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    /**
     * 데이터베이스에 user 저장
     */
    void save(User user);

    /**
     * email로 user 검색
     */
    Optional<User> findByEmail(@Param("email") String email);

    /**
     * id로 user 검색
     */
    Optional<User> findById(@Param("id") Long id);

    /**
     * user 리스트
     */
    List<User> findAll();
}
