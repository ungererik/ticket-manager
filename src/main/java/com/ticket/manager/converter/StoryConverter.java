package com.ticket.manager.converter;

import com.ticket.manager.dto.StoryDto;
import com.ticket.manager.entity.StoryEntity;
import org.springframework.stereotype.Component;

@Component
public class StoryConverter {

    public StoryDto convertToResponse(StoryEntity entity) {
        return StoryDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .status(entity.getStatus())
                .priority(entity.getPriority())
                .deadline(entity.getDeadline())
                .assigneeName(entity.getAssignee() != null ? entity.getAssignee().getUsername() : "Unassigned")
                .build();
    }
}