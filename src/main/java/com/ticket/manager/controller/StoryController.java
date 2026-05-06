package com.ticket.manager.controller;

import com.ticket.manager.dto.CreateStoryRequest;
import com.ticket.manager.dto.StoryDto;
import com.ticket.manager.model.StoryStatus;
import com.ticket.manager.service.StoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/story")
@RequiredArgsConstructor
public class StoryController {

    private final StoryService storyService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public StoryDto createStory(@RequestBody @Valid CreateStoryRequest request) {
        return storyService.createStory(request);
    }

    @PatchMapping("/{id}/status")
    public StoryDto updateStatus(
            @PathVariable Long id,
            @RequestParam StoryStatus newStatus) {
        return storyService.updateStatus(id, newStatus);
    }

    @GetMapping("/all")
    public List<StoryDto> getAllStories() {
        return storyService.getAllStories();
    }
}