package com.ticket.manager.dto;

import com.ticket.manager.model.StoryPriority;
import com.ticket.manager.model.StoryStatus;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class StoryDto {
    private Long id;
    private String title;
    private String description;
    private StoryStatus status;
    private StoryPriority priority;
    private LocalDate deadline;
    private String assigneeName;
}