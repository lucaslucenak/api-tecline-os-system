package com.lucaslucena.APIosSystemTecLine.services;

import com.lucaslucena.APIosSystemTecLine.models.UserModel;
import com.lucaslucena.APIosSystemTecLine.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserModel> findAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
