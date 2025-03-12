package com.cavichioli.user.service;

import com.cavichioli.user.fixture.UserFixture;
import com.cavichioli.user.repository.UserEntityRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserEntityRepo userEntityRepo;

    @InjectMocks
    UserService userService;

    @Test
    void shouldCreateUser() {
        var user = UserFixture.getUserEntity();
        when(userEntityRepo.save(any())).thenReturn(user);
        assertEquals(user, userService.createUser(any()));

        verify(userEntityRepo, times(1)).save(any());
    }

    @Test
    void shouldReturnAllUser() {
        var user = List.of(UserFixture.getUserEntity());
        when(userEntityRepo.findAll()).thenReturn(user);
        assertEquals(user, userService.getAllUsers());

        verify(userEntityRepo, times(1)).findAll();
    }

    @Test
    void shouldUpdateUser() {
        var user = UserFixture.getUserUpdated();
        var id = 123L;

        when(userEntityRepo.findById(id)).thenReturn(Optional.of(UserFixture.getUserEntity()));
        when(userEntityRepo.save(user)).thenReturn(user);

        assertEquals(user, userService.updateUser(id, UserFixture.getUserToUpdate()));
        verify(userEntityRepo, times(1)).save(user);
    }

    @Test
    void updateUserShouldReturnUserNotFound() {
        var user = UserFixture.getUserUpdated();
        var id = 123L;

        assertThrows(RuntimeException.class, () ->
            userService.updateUser(id, UserFixture.getUserToUpdate()));

        verify(userEntityRepo, times(1)).findById(id);
        verify(userEntityRepo, times(0)).save(user);
    }

    @Test
    void shouldReturnUserById() {
        var user = UserFixture.getUserEntity();
        var id = 123L;

        when(userEntityRepo.findById(id)).thenReturn(Optional.of(UserFixture.getUserEntity()));

        assertEquals(user, userService.getUserById(id));
        verify(userEntityRepo, times(1)).findById(id);
    }

    @Test
    void shouldDeleteUserById() {
        var id = 123L;
        userService.deleteUserById(id);

        verify(userEntityRepo, times(1)).deleteById(id);
    }

}
