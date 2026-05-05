package com.ticket.manager.dto;


import com.ticket.manager.model.PositionLevel;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String username;
    private String position;
    private PositionLevel levelOfPosition;

}
