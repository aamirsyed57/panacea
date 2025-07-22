package org.example.panacea.service;

import org.example.panacea.entity.User;
import org.example.panacea.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public Optional<User> findById(String id) {
        return userRepo.findById(id);
    }

    public Iterable<User> findAll() {
        return userRepo.findAll();
    }

    public void deleteById(String id) {
        userRepo.deleteById(id);
    }
}