package com.ticket.manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateTeamRequest {

    @NotBlank(message = "Team name can't be empty!")
    @Size(min = 2, max = 255, message = "Team name must be between 2 and 255 character long!" )
    private String name;

}
