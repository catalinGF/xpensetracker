package com.xpensetracker.app.service.api;

import com.xpensetracker.app.model.UserDTO;

import java.util.List;

public interface UserApiService {

    UserDTO getUserById(Long id);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUserById(Long id);

    List<UserDTO> getAllUsers();
}
