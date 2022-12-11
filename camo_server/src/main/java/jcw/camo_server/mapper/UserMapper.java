package jcw.camo_server.mapper;

import jcw.camo_server.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    /**
     * 데이터베이스에 user 저장
     */
    void userSave(User user);

    /**
     * email로 user 검색
     */
    Optional<User> findByEmail(@Param("email") String email);

    /**
     * id로 user 검색
     */
    Optional<User> findById(@Param("id") Long userId);

    /**
     * user 리스트
     */
    List<User> findAll();

    /**
     * user 수정
     */
    void userUpdate(User user);

    /**
     * user 권한 변경
     */
    void userRoleUpdate(User user);

    /**
     * user 삭제
     */
    void delete(User user);
}
