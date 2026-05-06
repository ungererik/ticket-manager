package com.ticket.manager.service;

import com.ticket.manager.converter.UserConverter;
import com.ticket.manager.dto.CreateUserRequest;
import com.ticket.manager.entity.TeamEntity;
import com.ticket.manager.entity.UserEntity;
import com.ticket.manager.repository.TeamRepository;
import com.ticket.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final UserConverter userConverter;

    @Transactional
    public UserEntity createUser(CreateUserRequest request) {
        UserEntity user = userConverter.convertToEntity(request);

        if (request.getTeamId() != null) {
            TeamEntity team = teamRepository.findById(request.getTeamId())
                    .orElseThrow(() -> new RuntimeException("Team not found"));
            user.setTeam(team);
        }

        return userRepository.save(user);
    }
}