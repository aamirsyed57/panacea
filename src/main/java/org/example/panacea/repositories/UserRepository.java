package org.example.panacea.repositories;

import org.example.panacea.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    List<User> findByName(String name);  // optional query method
}