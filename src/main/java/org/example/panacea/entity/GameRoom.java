package org.example.panacea.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@Data
@RedisHash("gameRoom")
public class GameRoom {
    @Id
    private String roomId;
    private String roomName;
    private List<User> users;
}
