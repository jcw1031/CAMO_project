package jcw.camo_server.mapper;

import jcw.camo_server.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user (user_email, user_password, user_name, user_phone, user_role) VALUES" +
            "(#{user.email}, #{user.password}, #{user.name}, #{user.phone}, #{user.role})")
    void save(@Param("user") User user);

    @Select("SELECT * FROM user WHERE user_email = #{email}")
    Optional<User> findByEmail(@Param("email") String email);

}
