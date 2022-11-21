package jcw.camoServer.repository;

import jcw.camoServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*@Modifying
    @Query(value = "INSERT INTO user VALUES (':#{#user.userId}', ':#{#user.email}', ':#{#user.password}', ':#{#user.name}'" +
        ", ':#{#user.phone}', ':#{#user.role}')", nativeQuery = true)
    void insert(@Param("user") User user);

    @Query(value = "SELECT u FROM User u WHERE u.userId = :userId")
    Optional<User> findUserById(@Param("userId") Long userId);

    @Query(value = "SELECT u FROM User u WHERE u.name = :name")
    Optional<User> findUserByName(@Param("name") String name);

    @Query(value = "SELECT u FROM User u")*/

    Optional<User> findByEmail(String email);
}
