package com.folksdev.basicauth.service;

import com.folksdev.basicauth.dto.CreateUserRequest;
import com.folksdev.basicauth.entity.User;
import com.folksdev.basicauth.enums.Status;
import com.folksdev.basicauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User createUser(CreateUserRequest request) {

        User newUser = User.builder()
                .firstName(request.firstName())
                .username(request.username())
                .password(passwordEncoder.encode(request.password()))
                .authorities(request.authorities())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .accountNonLocked(true)
                .enabled(true)
                .status(Status.valueOf("ACTIVE"))
                .build();

        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> getUserByName(String username) {
        return userRepository.findByUsername(username);
    }

}
