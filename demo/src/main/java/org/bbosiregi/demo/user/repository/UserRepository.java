package org.bbosiregi.demo.user.repository;

import org.bbosiregi.demo.user.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
//    Users findByUid();
}
