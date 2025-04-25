package com.xpensetracker.app.service;

import com.xpensetracker.app.model.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO getUserById(long id);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(long id, UserDTO userDTO);

    void deleteUserById(long id);

    List<UserDTO> getAllUsers();
}
