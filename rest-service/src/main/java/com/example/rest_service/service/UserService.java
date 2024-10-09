package com.example.rest_service.service;

import com.example.rest_service.dto.CreateUserDto;
import com.example.rest_service.dto.UpdateUserDto;
import com.example.rest_service.mapper.UserMapper;
import com.example.rest_service.model.User;
import com.example.rest_service.model.UserProperty;
import com.example.rest_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUser(Long id){

        return userRepository.findById(id).orElseThrow();
    }

    public User createUser(CreateUserDto userDto) {
        User user = new User();

        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        if (userDto.getProperties() != null) {
            List<UserProperty> userPropertyList = new ArrayList<UserProperty>();
            userDto.getProperties().forEach(property -> {
                UserProperty userProperty = new UserProperty();
                userProperty.setUser(user);
                userProperty.setCity(property.getCity());
                userProperty.setName(property.getName());
                userProperty.setAddress(property.getAddress());
                userPropertyList.add(userProperty);
            });
        user.setProperties(userPropertyList);
        }
        return userRepository.save(user);
    }


    public User updateUser( Long id, UpdateUserDto userDetails) {

        User user = userRepository.findById(id).orElseThrow();
        userMapper.updateUserFromDto(userDetails,user);

        return userRepository.save(user);

    }
}
