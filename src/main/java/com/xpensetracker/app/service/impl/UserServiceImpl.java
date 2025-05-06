package com.xpensetracker.app.service.impl;

import com.xpensetracker.app.entity.User;
import com.xpensetracker.app.exception.UserNotFoundException;
import com.xpensetracker.app.model.UserDTO;
import com.xpensetracker.app.repository.UserRepository;
import com.xpensetracker.app.service.UserService;
import com.xpensetracker.app.util.UserConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserConverter.convertDTOtoEntity(userDTO);
        User createdUser = userRepository.save(user);
        return UserConverter.convertEntityToDTO(createdUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        return UserConverter.convertEntityToDTO(foundUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = UserConverter.convertDTOtoEntity(userDTO);
        user.setId(id);
        User updatedUser = userRepository.save(user);
        return UserConverter.convertEntityToDTO(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allusers = userRepository.findAll();
        return allusers.stream()
                .map(UserConverter::convertEntityToDTO)
                .toList();
    }
}
