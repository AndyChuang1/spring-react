package com.example.rest_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateUserDto extends BaseUserDto {
    private List<UserPropertyDto> properties;
}
