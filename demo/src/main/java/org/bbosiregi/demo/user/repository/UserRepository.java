package org.bbosiregi.demo.user.repository;

import org.bbosiregi.demo.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByLoginIdAndPassword(String loginId, String password);
    boolean existsByLoginId(String s);
}
