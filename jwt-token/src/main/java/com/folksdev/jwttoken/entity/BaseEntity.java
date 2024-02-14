package com.folksdev.jwttoken.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}
