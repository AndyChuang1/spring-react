package com.example.rest_service.mapper;

import com.example.rest_service.dto.UpdateUserDto;
import com.example.rest_service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    // 定義映射方法，將非 null 的屬性從 userDetails 映射到 user
    void updateUserFromDto(UpdateUserDto userDetails, @MappingTarget User user);
}