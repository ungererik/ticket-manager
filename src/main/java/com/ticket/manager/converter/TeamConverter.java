package com.ticket.manager.converter;

import com.ticket.manager.dto.CreateTeamRequest;
import com.ticket.manager.entity.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class TeamConverter {

    public TeamEntity convertToEntity(CreateTeamRequest request) {
        TeamEntity entity = new TeamEntity();
        entity.setName(request.getName());
        return entity;
    }
}