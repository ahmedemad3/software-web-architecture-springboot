package com.solid.code.srp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.solid.code.srp.model.User;
import com.solid.code.srp.model.UserDTO;
import com.solid.code.srp.model.UserMapper;
import com.solid.code.srp.model.UserRequest;
import com.solid.code.srp.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO createUser(UserRequest request) {
        // Validate request and perform necessary transformations
        User user = new User(request.getUsername(), request.getEmail());
        userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    public UserDTO getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return UserMapper.toDTO(user.get());
        } else {
            return null;
        }
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
