package com.ticket.manager.controller;


import com.ticket.manager.dto.CreateTeamRequest;
import com.ticket.manager.service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/create")
    public ResponseEntity<Void> createTeam (@Valid @RequestBody CreateTeamRequest request) {

        teamService.createTeam(request);
        return ResponseEntity.ok().build();
    }

}
