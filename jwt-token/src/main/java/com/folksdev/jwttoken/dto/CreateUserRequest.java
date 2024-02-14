package com.folksdev.jwttoken.dto;
import com.folksdev.jwttoken.enums.Role;
import lombok.Builder;

import java.util.Set;


@Builder
public record CreateUserRequest(
        String firstName,
        String username,
        String password,
        Set<Role> authorities
){
}