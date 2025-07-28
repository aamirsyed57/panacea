package org.example.panacea.service;

import org.example.panacea.dto.UserInput;
import org.example.panacea.entity.User;
import org.example.panacea.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    public User save(UserInput userInput) {
        User newUser = new User();
        newUser.setName(userInput.getName());
        newUser.setEmail(userInput.getEmail());
        return userRepository.save(newUser);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}