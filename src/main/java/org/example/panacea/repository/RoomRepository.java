package org.example.panacea.repository;

import org.example.panacea.entity.Room;
import org.example.panacea.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, String> {
    List<Room> findByName(String name);  // optional query method
    List<Room> findA(String name);  // optional query method
}