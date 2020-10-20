package io.erickcernar.mysecondapp.domain.service;

import io.erickcernar.mysecondapp.domain.dto.User;
import io.erickcernar.mysecondapp.repository.UserRepository;
import io.erickcernar.mysecondapp.repository.mapper.UserMapper;
import io.erickcernar.mysecondapp.repository.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.MAPPER.toEntity(user);
        entity = this.userRepository.save(entity);
        user = UserMapper.MAPPER.toUser(entity);
        return user;
    }

    @Override
    public User update(User user) {
        UserEntity entity = UserMapper.MAPPER.toEntity(user);
        entity = this.userRepository.save(entity);
        user = UserMapper.MAPPER.toUser(entity);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> entities = this.userRepository.findAll();
        return UserMapper.MAPPER.toUsers(entities);
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository
                .findById(id)
                .map(UserMapper.MAPPER::toUser);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
