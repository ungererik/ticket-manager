package com.ticket.manager.service;

import com.ticket.manager.converter.UserConverter;
import com.ticket.manager.dto.CreateUserRequest;
import com.ticket.manager.entity.UserEntity;
import com.ticket.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Transactional
    public void createUser(CreateUserRequest request) {
        UserEntity userToSave = userConverter.convertToEntity(request);
        userRepository.save(userToSave);
    }
}