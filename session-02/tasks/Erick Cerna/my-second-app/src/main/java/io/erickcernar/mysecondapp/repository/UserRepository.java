package io.erickcernar.mysecondapp.repository;

import io.erickcernar.mysecondapp.repository.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
