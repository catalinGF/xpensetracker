package com.xpensetracker.service.impl;

import com.xpensetracker.app.repository.UserRepository;
import com.xpensetracker.app.service.UserService;
import com.xpensetracker.app.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;


    @Test
    void deleteUser(){
        UserService userService = new UserServiceImpl(userRepository);

        userService.deleteUserById(1L);

        Mockito.verify(userRepository).deleteById(1L);
    }

}
