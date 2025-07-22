package org.example.panacea.model;

import lombok.Data;

@Data
public class GameMessage {
    private String type;
    private String player;
    private String roomId;
    private String move;

    // Getters and Setters
}