package com.cavichioli.user.endpoint;

import com.cavichioli.user.fixture.UserFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
class UserControllerTest {

    @Autowired
    UserController userController;

    @BeforeEach
    void createUser() {
        userController.create(UserFixture.getUserRequest());
    }

    @Test
    void shouldGetUserById() {
        var response = userController.getUserById(1L);
        Assertions.assertThat(response.getBody())
                .usingRecursiveComparison()
                .ignoringFields("creationDate")
                .ignoringFields("updateDate")
                .isEqualTo(UserFixture.getUserResponse());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shouldUpdateUser() {
        var response = userController.updateUser(1L, UserFixture.getUserToUpdate());
        Assertions.assertThat(response.getBody())
                .usingRecursiveComparison()
                .ignoringFields("creationDate")
                .ignoringFields("updateDate")
                .isEqualTo(UserFixture.getUserResponseUpdated());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
