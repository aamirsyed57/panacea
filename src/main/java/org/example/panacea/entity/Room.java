package org.example.panacea.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("room")
@Data
public class Room implements Serializable {
    @Id
    @Schema(description = "UUId of the Room", example = "uuid")
    private String id;
    @Schema(description = "name of the Room" , example = "room123")
    private String name;
    @Schema(description = "User ID of the user who created the room", example = "uuid")
    private String userId;
}