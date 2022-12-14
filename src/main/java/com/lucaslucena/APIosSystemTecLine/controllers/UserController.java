package com.lucaslucena.APIosSystemTecLine.controllers;

import com.lucaslucena.APIosSystemTecLine.models.RoleModel;
import com.lucaslucena.APIosSystemTecLine.models.UserModel;
import com.lucaslucena.APIosSystemTecLine.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;
    final ModelMapper modelMapper;
//    final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, ModelMapper modelMapper/*, PasswordEncoder passwordEncoder*/) {
        this.userService = userService;
        this.modelMapper = modelMapper;
//        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel createUser(@RequestBody UserModel user) {
//        user.addRole(new RoleModel(3L, "CLIENT"));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.saveUser(user);
    }

    @GetMapping("{id}")
    public UserModel getUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @GetMapping
    public List<UserModel> getAllUsers() {
        return userService.findAllUsers();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable Long id) {
        userService.findUserById(id)
                .map(user -> {
                    userService.deleteUserById(user.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable("id") Long id, @RequestBody UserModel newUser) {
        userService.findUserById(id)
                .map(user -> {
                            modelMapper.map(newUser, user);
                            userService.saveUser(user);
                            return Void.TYPE;
                        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }
}
