package com.cavichioli.user.endpoint;

import com.cavichioli.user.endpoint.representation.UserRequest;
import com.cavichioli.user.endpoint.representation.UserResponse;
import com.cavichioli.user.endpoint.representation.UserUpdate;
import com.cavichioli.user.facade.UserFacade;
import com.cavichioli.user.mapper.UserMapper;
import com.cavichioli.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/user"})
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserFacade userFacade;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userFacade.createUser(userRequest));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userFacade.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userFacade.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserUpdate userUpdate) {
        return ResponseEntity.ok(userFacade.updateUser(id, userUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userFacade.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
