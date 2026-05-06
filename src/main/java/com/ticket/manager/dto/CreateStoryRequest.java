package com.ticket.manager.dto;

import com.ticket.manager.model.StoryPriority;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateStoryRequest {
    @NotBlank
    private String title;
    private String description;
    private StoryPriority priority;
    private LocalDate deadline;
    private Long assigneeId;
}
