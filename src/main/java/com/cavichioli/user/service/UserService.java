package com.cavichioli.user.service;

import com.cavichioli.user.endpoint.representation.UserRequest;
import com.cavichioli.user.endpoint.representation.UserUpdate;
import com.cavichioli.user.mapper.UserMapper;
import com.cavichioli.user.model.UserEntity;
import com.cavichioli.user.repository.UserEntityRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepo userEntityRepo;

    public UserEntity createUser(UserRequest userRequest) {
        return userEntityRepo.save(UserMapper.INSTANCE.mapToEntity(userRequest));
    }

    public List<UserEntity> getAllUsers() {
        return userEntityRepo.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userEntityRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Usuário com id %s, não encontrado", id)));
    }

    public UserEntity updateUser(Long id, UserUpdate userUpdate) {
        var userSaved =  userEntityRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Usuário com id %s, não encontrado", id)));

        var userToUpdate = UserMapper.INSTANCE.mapToUpdate(userUpdate);
        return userEntityRepo.save(builderUpdateUser(userSaved, userToUpdate));
    }

    public void deleteUserById(Long id) {
        userEntityRepo.deleteById(id);
    }

    private UserEntity builderUpdateUser(UserEntity userSaved, UserEntity userToUpdate) {
        userSaved.setName(userToUpdate.getName());
        userSaved.setEmail(userToUpdate.getEmail());
        userSaved.setAdmin(userToUpdate.getAdmin());
        return userSaved;

    }
}
