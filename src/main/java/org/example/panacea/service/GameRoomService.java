package org.example.panacea.service;

import org.example.panacea.entity.Room;
import org.example.panacea.entity.User;
import org.example.panacea.repository.GameRoomRepository;
import org.example.panacea.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GameRoomService {

    private final GameRoomRepository gameRoomRepository;
    private final RoomRepository roomRepo;

    public GameRoomService(GameRoomRepository gameRoomRepository, RoomRepository roomRepo) {
        this.gameRoomRepository = gameRoomRepository;
        this.roomRepo = roomRepo;
    }

    public Room createRoom(String name, String userId) {
        Room room = new Room();
        room.setId(UUID.randomUUID().toString());
        room.setName(name);
        room.setUserId(userId);
        return roomRepo.save(room);
    }

    public List<Room> getRoomsByName(String name) {
        return roomRepo.findByName(name);
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        roomRepo.findAll().forEach(rooms::add);
        return rooms;
    }
/*
    public List<Room> getPaginatedRooms(int page, int pageSize) {
        Iterable<Room> all = roomRepo.find();
        return ;
    }

 */
}