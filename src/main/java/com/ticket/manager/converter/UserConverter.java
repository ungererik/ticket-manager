package com.ticket.manager.converter;

import com.ticket.manager.dto.CreateUserRequest;
import com.ticket.manager.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertToEntity(CreateUserRequest request) {
        UserEntity entity = new UserEntity();
        entity.setUsername(request.getUsername());
        entity.setPosition(request.getPosition());
        entity.setLevelOfPosition(request.getLevelOfPosition());

        return entity;
    }
}