package com.xpensetracker.app.service.impl;

import com.xpensetracker.app.entity.User;
import com.xpensetracker.app.exception.UserNotFoundException;
import com.xpensetracker.app.model.UserDTO;
import com.xpensetracker.app.repository.UserRepository;
import com.xpensetracker.app.service.web.UserWebService;
import com.xpensetracker.app.util.UserConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserWebServiceImpl implements UserWebService {

    private final UserRepository userRepository;

    public UserWebServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserConverter.convertDTOtoEntity(userDTO);
        User createdUser = userRepository.save(user);
        return UserConverter.convertEntityDTO(createdUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        return UserConverter.convertEntityDTO(foundUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = UserConverter.convertDTOtoEntity(userDTO);
        user.setId(id);
        User updatedUser = userRepository.save(user);
        return UserConverter.convertEntityDTO(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allusers = userRepository.findAll();
        return allusers.stream()
                .map(UserConverter::convertEntityDTO)
                .toList();
    }
}
