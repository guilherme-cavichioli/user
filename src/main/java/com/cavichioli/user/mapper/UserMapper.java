package com.cavichioli.user.mapper;

import com.cavichioli.user.endpoint.representation.UserRequest;
import com.cavichioli.user.endpoint.representation.UserResponse;
import com.cavichioli.user.endpoint.representation.UserUpdate;
import com.cavichioli.user.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userRequest.admin", target = "admin", defaultValue = "false")
    UserEntity mapToEntity(UserRequest userRequest);

    UserResponse mapToResponse(UserEntity userEntity);

    UserEntity mapToUpdate(UserUpdate userUpdate);

}
