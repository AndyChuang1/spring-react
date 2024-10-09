package com.example.rest_service.dto;

import com.example.rest_service.model.UserProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BaseUserDto {
    @Schema(description = "The username of the user", example = "john_doe")
    private String name;

    @Schema(description = "The email address of the user", example = "john.doe@example.com")
    private String email;
}

