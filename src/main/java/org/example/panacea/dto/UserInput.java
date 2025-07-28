package org.example.panacea.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserInput {
    @Schema(description = "name of Room", example = "alice")
    public String name;
    @Schema(description = "email of User", example = "alice@gmail.com")
    public String email;
}
