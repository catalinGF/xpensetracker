package com.xpensetracker.app.util;

import com.xpensetracker.app.entity.User;
import com.xpensetracker.app.model.UserDTO;

public class UserConverter {

    private UserConverter() {
    }

    public static UserDTO convertEntitytoDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }
    public static User convertDTOtoEntity(UserDTO userDTO) {
        return new User(userDTO.id(), userDTO.name(), userDTO.email());
    }
}
