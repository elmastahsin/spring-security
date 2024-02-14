package com.folksdev.basicauth;

import com.folksdev.basicauth.dto.CreateUserRequest;
import com.folksdev.basicauth.enums.Role;
import com.folksdev.basicauth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {
    private final UserService userService;

    public BasicAuthApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicAuthApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createDummyData();
    }

    private void createDummyData() {
        CreateUserRequest request = CreateUserRequest.builder()
                .firstName("User")
                .username("user")
                .password("user")
                .authorities(Set.of(Role.ROLE_USER))
                .build();
        userService.createUser(request);

        CreateUserRequest request2 = CreateUserRequest.builder()
                .firstName("admin")
                .username("admin")
                .password("admin")
                .authorities(Set.of(Role.ROLE_ADMIN))
                .build();
        userService.createUser(request2);


        CreateUserRequest request3 = CreateUserRequest.builder()
                .firstName("Operator")
                .username("operator")
                .password("operator")
                .authorities(Set.of(Role.ROLE_OPERATOR))
                .build();
        userService.createUser(request3);
    }
}