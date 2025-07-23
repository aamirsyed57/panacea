package org.example.panacea.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("user")
@Data
public class User implements Serializable {
    @Id
    @Schema(description = "UUId of the User" , example = "uuid")
    private String id;
    @Schema(description = "Name of the User", example = "Alice")
    private String name;
}