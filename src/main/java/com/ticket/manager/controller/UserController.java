package com.ticket.manager.controller;


import com.ticket.manager.dto.CreateUserRequest;
import com.ticket.manager.entity.UserEntity;
import com.ticket.manager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user") // Visszaírtam egyes számra, hogy hasonlítson a team-re
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create") // Most már itt is KELL a /create
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@RequestBody @Valid CreateUserRequest request) {
        return userService.createUser(request);
    }
}