package com.ticket.manager.service;

import com.ticket.manager.converter.StoryConverter;
import com.ticket.manager.dto.CreateStoryRequest;
import com.ticket.manager.dto.StoryDto;
import com.ticket.manager.entity.StoryEntity;
import com.ticket.manager.entity.UserEntity;
import com.ticket.manager.model.StoryStatus;
import com.ticket.manager.repository.StoryRepository;
import com.ticket.manager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoryService {

    private final StoryRepository storyRepository;
    private final UserRepository userRepository;
    private final StoryConverter storyConverter;


    @Transactional
    public StoryDto createStory(CreateStoryRequest request) {
        StoryEntity story = new StoryEntity();
        story.setTitle(request.getTitle());
        story.setDescription(request.getDescription());
        story.setPriority(request.getPriority());
        story.setDeadline(request.getDeadline());


        story.setStatus(StoryStatus.PLANNING);

        if (request.getAssigneeId() != null) {
            UserEntity user = userRepository.findById(request.getAssigneeId())
                    .orElseThrow(() -> new RuntimeException("User not found with id: " + request.getAssigneeId()));
            story.setAssignee(user);
        }

        StoryEntity savedStory = storyRepository.save(story);
        return storyConverter.convertToResponse(savedStory);
    }

    @Transactional
    public StoryDto updateStatus(Long id, StoryStatus newStatus) {
        StoryEntity story = storyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Story not found with id: " + id));

        story.setStatus(newStatus);
        StoryEntity updatedStory = storyRepository.save(story);

        return storyConverter.convertToResponse(updatedStory);
    }

    @Transactional(readOnly = true)
    public List<StoryDto> getAllStories() {
        return storyRepository.findAll().stream()
                .map(storyConverter::convertToResponse)
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public StoryDto getStoryById(Long id) {
        StoryEntity story = storyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Story not found with id: " + id));
        return storyConverter.convertToResponse(story);
    }
}