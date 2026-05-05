package com.ticket.manager.service;

import com.ticket.manager.converter.TeamConverter;
import com.ticket.manager.dto.CreateTeamRequest;
import com.ticket.manager.entity.TeamEntity;
import com.ticket.manager.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamConverter teamConverter;

    @Transactional
    public void createTeam(CreateTeamRequest request) {

        TeamEntity teamToSave = teamConverter.convertToEntity(request);

        teamRepository.save(teamToSave);
    }
}