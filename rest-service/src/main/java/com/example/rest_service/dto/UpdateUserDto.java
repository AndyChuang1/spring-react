package com.example.rest_service.dto;

import com.example.rest_service.model.UserProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateUserDto extends BaseUserDto {
    private Integer isVerify;
}
