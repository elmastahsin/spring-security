package com.folksdev.basicauth.dto;
import com.folksdev.basicauth.enums.Role;
import lombok.Builder;

import java.util.Set;


@Builder
public record CreateUserRequest (
        String firstName,
        String username,
        String password,
        Set<Role> authorities
){
}