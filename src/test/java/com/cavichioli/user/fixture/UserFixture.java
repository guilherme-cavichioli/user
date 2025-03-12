package com.cavichioli.user.fixture;

import com.cavichioli.user.endpoint.representation.UserRequest;
import com.cavichioli.user.endpoint.representation.UserResponse;
import com.cavichioli.user.endpoint.representation.UserUpdate;
import com.cavichioli.user.model.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserFixture {

    public UserEntity getUserEntity() {
        return UserEntity.builder()
                .id(123L)
                .name("Guilherme")
                .document("788.449.470-13")
                .email("teste@gmail.com")
                .build();
    }

    public UserEntity getUserUpdated() {
        return UserEntity.builder()
                .id(123L)
                .name("Guilherme Neves")
                .document("788.449.470-13")
                .email("teste123@gmail.com")
                .admin(Boolean.FALSE)
                .build();
    }

    public UserUpdate getUserToUpdate() {
        return UserUpdate.builder()
                .name("Guilherme Neves")
                .email("teste123@gmail.com")
                .admin(Boolean.FALSE)
                .build();
    }

    public UserRequest getUserRequest() {
        return UserRequest.builder()
                .name("Guilherme")
                .document("788.449.470-13")
                .email("teste@gmail.com")
                .admin(Boolean.FALSE)
                .build();
    }

    public UserResponse getUserResponse() {
        return UserResponse.builder()
                .id(1L)
                .name("Guilherme")
                .document("788.449.470-13")
                .email("teste@gmail.com")
                .admin(Boolean.FALSE)
                .build();
    }

    public UserResponse getUserResponseUpdated() {
        return UserResponse.builder()
                .id(1L)
                .name("Guilherme Neves")
                .document("788.449.470-13")
                .email("teste123@gmail.com")
                .admin(Boolean.FALSE)
                .build();
    }
}
