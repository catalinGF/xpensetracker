package com.xpensetracker.app.controller;

import com.xpensetracker.app.model.UserDTO;
import com.xpensetracker.app.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @Tag(name = "Get User By Id", description = "Get a user from database by id")
    public UserDTO getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    @Tag(name = "Get All Users", description = "Get all users from database")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }


    @PutMapping("/{id}")
    @Tag(name = "Update User", description = "Update a user in database")
    public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "Delete User", description = "Delete a user from database")
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
    }
    @PostMapping
    @Tag(name = "Create User", description = "Create a user in database")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }
}
