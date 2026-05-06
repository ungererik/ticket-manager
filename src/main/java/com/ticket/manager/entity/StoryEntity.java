package com.ticket.manager.entity;

import com.ticket.manager.model.StoryPriority;
import com.ticket.manager.model.StoryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "stories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private StoryStatus status = StoryStatus.PLANNING;

    @Enumerated(EnumType.STRING)
    private StoryPriority priority;

    private LocalDate deadline;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private UserEntity assignee;
}
