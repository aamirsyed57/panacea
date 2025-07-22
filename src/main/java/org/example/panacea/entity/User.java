package org.example.panacea.entity;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("User")
@Data
public class User implements Serializable {
    private String id;
    private String name;
}