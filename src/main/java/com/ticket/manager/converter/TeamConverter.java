package com.ticket.manager.converter;

import com.ticket.manager.dto.CreateTeamRequest;
import com.ticket.manager.entity.TeamEntity;

public class TeamConverter {

    public static TeamEntity convertToEntity(CreateTeamRequest request) {
        TeamEntity entity = new TeamEntity();
        entity.setName(request.getName());
        return entity;
    }
}