package com.ticket.manager.converter;

import com.ticket.manager.dto.CreateUserRequest;
import com.ticket.manager.entity.TeamEntity;
import com.ticket.manager.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserConverter {

    private final TeamConverter teamConverter;

    public UserEntity convertToEntity(CreateUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setUsername(request.getUsername());
        entity.setPosition(request.getPosition());
        entity.setLevelOfPosition(request.getLevelOfPosition());

        List<TeamEntity> teamEntities = request.getTeams().stream()
                .map(teamDto -> teamConverter.convertToEntity(teamDto))
                .collect(Collectors.toList());

        entity.setTeams(teamEntities);

        return entity;
    }
}