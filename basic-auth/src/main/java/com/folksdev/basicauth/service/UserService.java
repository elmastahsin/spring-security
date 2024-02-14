package com.folksdev.basicauth.service;

import com.folksdev.basicauth.dto.CreateUserRequest;
import com.folksdev.basicauth.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    User createUser(CreateUserRequest user);
    Optional<User> getUserByName(String username);

}
