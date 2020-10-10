package io.erickcernar.mysecondapp.repository.mapper;

import io.erickcernar.mysecondapp.domain.dto.User;
import io.erickcernar.mysecondapp.repository.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userId", source = "id")
    User toUser(UserEntity userEntity);

    @Mapping(target = "id", source = "userId")
    UserEntity toEntity(User user);

    List<User> toUsers(List<UserEntity> userEntity);

}