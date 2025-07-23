package org.example.panacea.repository;

import org.example.panacea.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class GameRoomRepository {

    private RedisTemplate<String, User> redisUserListTemplate;

    public void addPlayerToRoom(String roomId, User user) {
        String key = "room:" + roomId + ":players";
        redisUserListTemplate.opsForList().rightPush(key, user);
    }

    public List<User> getUsers(String roomId) {
        String key = "room:" + roomId + ":players";
        return redisUserListTemplate.opsForList().range(key, 0, -1);
    }

}
