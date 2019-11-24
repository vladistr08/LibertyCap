package com.itec.app.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

;
import com.itec.app.Entity.Role;
import com.itec.app.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);

    @Query("SELECT user FROM User user WHERE user.email=?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT user FROM User user WHERE user.lastName=?1")
    User findUserByLastName(String lastName);

    @Query("SELECT user FROM User user WHERE user.id=?1")
    User findUserById(Long id);

    @Query("SELECT user.id FROM User user WHERE user.email=?1")
    Long findIdByEmail(String email);
}
