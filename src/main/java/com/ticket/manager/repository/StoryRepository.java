package com.ticket.manager.repository;

import com.ticket.manager.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StoryRepository extends JpaRepository<StoryEntity, Long> {

}

