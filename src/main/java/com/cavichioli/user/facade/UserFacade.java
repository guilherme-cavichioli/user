package com.cavichioli.user.facade;

import com.cavichioli.user.endpoint.representation.UserRequest;
import com.cavichioli.user.endpoint.representation.UserResponse;
import com.cavichioli.user.endpoint.representation.UserUpdate;
import com.cavichioli.user.mapper.UserMapper;
import com.cavichioli.user.service.UserService;
import com.cavichioli.user.service.strategy.CreationUserNotificationStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserFacade {

    private final UserService userService;

    private final List<CreationUserNotificationStrategy> creationUserNotificationStrategies;

    public UserResponse createUser(UserRequest userRequest) {
        log.info("[CREATE USER] - Usuário {} recebido para criação.", userRequest);
        var userEntity = userService.createUser(userRequest);

        creationUserNotificationStrategies.stream()
                .filter(strategy -> strategy.canHandle(userEntity.getAdmin()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Atributo admin nulo para usuário: %s", userEntity)))
                .sendCreationNotification(userEntity);

        return UserMapper.INSTANCE.mapToResponse(userEntity);
    }

    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers()
                .stream().map(UserMapper.INSTANCE::mapToResponse).collect(Collectors.toList());
    }

    public UserResponse getUserById(Long id) {
        return UserMapper.INSTANCE.mapToResponse(userService.getUserById(id));
    }

    public UserResponse updateUser(Long id, UserUpdate userUpdate) {
        log.info("[UPDATE USER] - Usuário {} recebido para atualização.", userUpdate);
        return UserMapper.INSTANCE.mapToResponse(userService.updateUser(id, userUpdate));
    }

    public void deleteUserById(Long id) {
        log.info("[DELETE USER] - Id {} recebido para deleção.", id);
        userService.deleteUserById(id);
    }
}
