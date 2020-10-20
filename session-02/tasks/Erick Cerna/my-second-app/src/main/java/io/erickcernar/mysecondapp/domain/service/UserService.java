package io.erickcernar.mysecondapp.domain.service;

import io.erickcernar.mysecondapp.domain.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(User user);
    User update(User user);
    List<User> findAll();
    Optional<User> findById(Long id);
    void deleteById(Long id);
}
