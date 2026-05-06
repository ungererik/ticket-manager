package com.ticket.manager.dto;

import com.ticket.manager.model.PositionLevel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.List;

@Data
public class CreateUserRequest {

    @NotBlank(message = "Username cannot be empty!")
    @Size(min = 2, max = 255, message = "Username must be between 2 and 255 characters long!")
    private String username;

    @NotBlank(message = "Position cannot be empty!")
    private String position;

    @NotNull(message = "Position level is required!")
    private PositionLevel levelOfPosition;

    @NotNull(message = "At least one team must be assigned!")
    @Valid
    private Long teamId;
}