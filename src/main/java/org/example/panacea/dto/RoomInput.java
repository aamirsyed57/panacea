package org.example.panacea.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RoomInput {
    @Schema(description = "name of Room", example = "room123")
    public String name;
}
