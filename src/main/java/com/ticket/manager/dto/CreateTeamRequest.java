package com.ticket.manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTeamRequest {

    @NotBlank(message = "Team name cannot be empty!")
    @Size(min = 2, max = 255, message = "Team name must be between 2 and 255 characters long!")
    private String name;
}