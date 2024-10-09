package com.example.rest_service.service;

import com.example.rest_service.mapper.UserMapper;
import com.example.rest_service.model.User;
import com.example.rest_service.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    private User user;

    AutoCloseable mocks;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john@example.com");



        mocks = MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));

        List<User> users = userService.getAllUsers();

        assertNotNull(users);
        assertEquals(1, users.size());

        verify(userRepository, times(1)).findAll();
    }
}
