package com.xpensetracker.app.controller.api;

import com.xpensetracker.app.model.UserDTO;
import com.xpensetracker.app.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User", description = "User operations")
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    /*C R U D*/

    /*Create the user*/
    @PostMapping
    @Operation(summary = "Create a user in database")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    /*READ or Get the user by id*/
    @GetMapping("/{id}")
    @Operation(summary = "Get a user from database by id")
    public UserDTO getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    /*Update the user*/
    @PutMapping("/{id}")
    @Operation(summary = "Update a user in database")
    public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    /*Delete the user*/
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user from database")
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
    }

    /*Get al the user from database*/
    @GetMapping
    @Operation(summary = "Get all users from database")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }
}
