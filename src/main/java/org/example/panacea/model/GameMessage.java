package org.example.panacea.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class GameMessage {
    @Schema(description = "Type of message (e.g. 'move')", example = "move")
    private String type;
    @Schema(description = "Name of the player", example = "Alice")
    private String player;
    @Schema(description = "Room ID", example = "room123")
    private String roomId;
    @Schema(description = "The actual move", example = "left")
    private String move;

    // Getters and Setters
}