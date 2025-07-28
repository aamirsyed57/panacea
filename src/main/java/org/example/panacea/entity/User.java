package org.example.panacea.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "game_users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Name of the User", example = "Alice")
    private String name;

    @Column(unique = true)
    @Schema(description = "Email of the User", example = "alice@gmail.com")
    private String email;
}